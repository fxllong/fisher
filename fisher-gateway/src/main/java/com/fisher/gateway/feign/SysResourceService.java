package com.fisher.gateway.feign;

import com.fisher.common.vo.SysResourceVO;
import com.fisher.gateway.config.FeignConfig;
import com.fisher.gateway.feign.fallback.SysResourceFallback;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@FeignClient(name = "fisher-back-service",fallback = SysResourceFallback.class, configuration = FeignConfig.class)
public interface SysResourceService {

    /**
     * 根据角色查询资源信息
     * @param roleCode
     * @return
     */
    @GetMapping("/resource/role/{roleCode}")
    Set<SysResourceVO> listResourceByRole(@PathVariable("roleCode") String roleCode);


}
