package com.fisher.common.constants;

/**
 * @description: 安全配置常量
 */
public interface SecurityConstants {

    /**
     * token的header key
     */
   String TOKEN_HEADER = "Authorization";

   String CLOUD = "fisher";

   String CLOUD_PREFIX = "fisher_";

    /**
     * jwt 加密key
     */
   String SIGN_KEY = "FISHER";

    /**
     * sys_oauth_client_details 字段
     */
   String CLIENT_FIELDS = "client_id, client_secret, resources_ids, scope, authorized_grant_types,"
           + "web_server_redirect_uri, authorities, access_token_validity,"
           + "refresh_token_validity, addition_information, autoapprove";

    /**
     * jdbcClientDetailsService查询sql
     */
   String BASE_FIND_STATEMENT = "select " + CLIENT_FIELDS + " from sys_oauth_client_details";

    /**
     * 默认查询语句
     */
   String DEFAULT_FIND_STATEMENT = BASE_FIND_STATEMENT + " order by client_id";

    /**
     * 根据client_id查询
     */
   String DEFAULT_FIND_STATEMENT_BY_CLIENT_ID = BASE_FIND_STATEMENT + " where client_id = ?";


   String SPRING_SECURITY_MOBILE_KEY = "mobile";

   String SPRING_SECURITY_CODE_KEY = "code";

    /**
     * 手机验证码登录的地址
     */
   String SPRING_SECURITY_MOBILE_TOKEN_URL = "/mobile/token";


   String REDIS_CODE_PREFIX = "fisher_code_";

   Integer REDIS_CODE_EXPIRE = 60;

}
