package com.fisher.gateway.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface SysPermissionService {

    /**
     * 判断当前用户是否有权限请求该url
     * @param request
     * @param authentication
     * @return
     */
    Boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
