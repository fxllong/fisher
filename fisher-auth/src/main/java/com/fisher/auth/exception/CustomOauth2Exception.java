package com.fisher.auth.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fisher.auth.serializer.CustomOauthExceptionSerializer;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @description: oauth2自定义异常
 */
@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class CustomOauth2Exception extends OAuth2Exception {

    public CustomOauth2Exception(String msg) {
        super(msg);
    }
}
