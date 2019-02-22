package com.fisher.back.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * oauth2客户端资源认证表
 * </p>
 *
 */
@Data
@Accessors(chain = true)
public class SysOauthClientDetails {

    private static final long serialVersionUID = 1L;

    private String clientId;

    private String resourcesIds;

    private String clientSecret;

    private String scope;

    private String authorizedGrantTypes;

    private String webServerRedirectUri;

    private String authorities;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String additionInformation;

    private String autoapprove;


}
