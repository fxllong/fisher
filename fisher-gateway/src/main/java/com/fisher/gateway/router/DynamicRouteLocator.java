package com.fisher.gateway.router;


import com.fisher.gateway.entity.SysZuulRoute;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @description: 动态路由实现
 */
@Slf4j
public class DynamicRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    private ZuulProperties properties;

    private JdbcTemplate jdbcTemplate;

    public DynamicRouteLocator(String servletPath, ZuulProperties properties, JdbcTemplate jdbcTemplate) {
        super(servletPath, properties);
        this.properties = properties;
        this.jdbcTemplate = jdbcTemplate;
        log.info("servletPath:{}",servletPath);
    }

    @Override
    public void refresh() {
        doRefresh();
    }

    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
        LinkedHashMap<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<String, ZuulProperties.ZuulRoute>();
        //从application.properties中加载路由信息
        routesMap.putAll(super.locateRoutes());
        //从db中加载路由信息
        routesMap.putAll(locateRoutesFromDB());
        //优化一下配置
        LinkedHashMap<String, ZuulProperties.ZuulRoute> values = new LinkedHashMap<>();
        for (Map.Entry<String, ZuulProperties.ZuulRoute> entry : routesMap.entrySet()) {
            String path = entry.getKey();
            // Prepend with slash if not already present.
            if (!path.startsWith("/")) {
                path = "/" + path;
            }
            if (StringUtils.hasText(this.properties.getPrefix())) {
                path = this.properties.getPrefix() + path;
                if (!path.startsWith("/")) {
                    path = "/" + path;
                }
            }
            values.put(path, entry.getValue());
        }
        return values;
    }

    /**
     * 从数据库读取zuul路由规则
     * @return
     */
   private LinkedHashMap<String, ZuulProperties.ZuulRoute> locateRoutesFromDB() {
        LinkedHashMap<String, ZuulProperties.ZuulRoute> zuulRoutes = new LinkedHashMap<>();
        List<SysZuulRoute> sysZuulRoutes = jdbcTemplate.query("select * from sys_zuul_route where del_flag = 0", new BeanPropertyRowMapper<>(SysZuulRoute.class));

       for (SysZuulRoute route: sysZuulRoutes) {

           // 为空跳过
           if (Strings.isNullOrEmpty(route.getPath()) && Strings.isNullOrEmpty(route.getUrl())) {
               continue;
           }

           ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
           try {
               zuulRoute.setId(route.getServiceId());
               zuulRoute.setPath(route.getPath());
               zuulRoute.setServiceId(route.getServiceId());
               zuulRoute.setRetryable(Objects.equals("0", route.getRetryable()) ? Boolean.FALSE : Boolean.TRUE);
               zuulRoute.setStripPrefix(Objects.equals("0", route.getStripPrefix()) ? Boolean.FALSE : Boolean.TRUE);
               zuulRoute.setUrl(route.getUrl());
               List<String> sensitiveHeadersList = Arrays.asList(route.getSensitiveheadersList().split(","));
               if (sensitiveHeadersList != null) {
                   Set<String> sensitiveHeaderSet = Sets.newHashSet();
                   sensitiveHeadersList.forEach(sensitiveHeader -> sensitiveHeaderSet.add(sensitiveHeader));
                   zuulRoute.setSensitiveHeaders(sensitiveHeaderSet);
                   zuulRoute.setCustomSensitiveHeaders(true);
               }
           } catch (Exception e) {
               log.error("从数据库加载路由配置异常", e);
           }
           log.debug("添加数据库自定义的路由配置,path：{}，serviceId:{}", zuulRoute.getPath(), zuulRoute.getServiceId());
           zuulRoutes.put(zuulRoute.getPath(), zuulRoute);

       }
        return zuulRoutes;
   }
}
