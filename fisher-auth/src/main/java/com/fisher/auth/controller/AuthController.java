package com.fisher.auth.controller;

import com.fisher.auth.query.OAuth2AccessTokenQuery;
import com.fisher.common.constants.CommonConstants;
import com.fisher.common.constants.SecurityConstants;
import com.fisher.common.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @Autowired
    private RedisTokenStore redisTokenStore;

    @DeleteMapping("/token/{token}")
    public ApiResult<Boolean> removeAccessToken(@PathVariable("token") String token) {
        return new ApiResult<>(consumerTokenServices.revokeToken(token));
    }

    @GetMapping("/token")
    public ApiResult<Collection<OAuth2AccessToken>> readAllToken() {
        return new ApiResult<>(redisTokenStore.findTokensByClientId(SecurityConstants.CLOUD));
    }

    @GetMapping("/token/page")
    public ApiResult getTokenList(OAuth2AccessTokenQuery oAuth2AccessTokenQuery) {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        oAuth2AccessTokenQuery.setRecords((List)redisTemplate.opsForList().range(CommonConstants.FISHER_REDIS_LIST_LEY, oAuth2AccessTokenQuery.getStart(), oAuth2AccessTokenQuery.getEnd()));
        List<OAuth2AccessToken> all = (List)redisTemplate.opsForList().range(CommonConstants.FISHER_REDIS_LIST_LEY, 0, -1);
        if(all != null){
            oAuth2AccessTokenQuery.setTotal(all.size());
        }
        return new ApiResult(oAuth2AccessTokenQuery);
    }

}
