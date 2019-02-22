package com.fisher.gateway.auth.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fisher.common.enums.ResponseCodeEnum;
import com.fisher.common.exception.PermissionDefinedException;
import com.fisher.common.util.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 授权失败(forbidden)时返回信息
 */

@Slf4j
@Component("customAccessDeniedHandler")
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Autowired
    private ObjectMapper objectMapper;

    /**
     *  授权拒绝处理器
     * @param request
     * @param response
     * @param accessDeniedException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.info("授权失败, 禁止访问{}", request.getRequestURI());
        response.setContentType("application/json;charset=UTF-8");
        ApiResult<String> result = new ApiResult<>(new PermissionDefinedException(), ResponseCodeEnum.PERMISSION_DEFINED);
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}


