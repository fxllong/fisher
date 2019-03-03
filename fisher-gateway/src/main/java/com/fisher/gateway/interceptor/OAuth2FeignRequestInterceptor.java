package com.fisher.gateway.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

@Slf4j
@Configuration
public class OAuth2FeignRequestInterceptor implements RequestInterceptor {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private static final String AUTHORIZATION_HEADER = "Authorization";

    private static final String BEARER_TOKEN_TYPE = "Bearer";
    @Override
    public void apply(RequestTemplate requestTemplate) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null && authentication.getDetails() instanceof OAuth2AuthenticationDetails) {
            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
            requestTemplate.header(AUTHORIZATION_HEADER, String.format("%s %s", BEARER_TOKEN_TYPE, details.getTokenValue()));
        }

    }
}