package com.fisher.auth.query;

import lombok.Data;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import java.util.List;

@Data
public class OAuth2AccessTokenQuery {

    private Integer size = 10;


    private Integer current = 1;

    private Integer pages = 1;

    private Integer total = 0;

    private List<OAuth2AccessToken> records;

    public Integer getStart() {
        return (current-1) * size;
    }

    public Integer getEnd() {
        return current * size - 1;
    }
}
