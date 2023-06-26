package com.lynwood.g.base.soi.common.constants;
/**
 * @author： Lynwood
 */
public interface SecurityConstants {

    String G_BASIC_TOKEN = "Authorization";
    /**
     * Basic认证前缀
     */
    String G_BASIC_PREFIX = "Basic ";

    /**
     * 认证请求头key
     */
    String G_ACCESS_TOKEN = "G-Access-Token";

    /**
     * JWT令牌前缀
     */
    String G_JWT_PREFIX = "Bearer ";

    /**
     * JWT载体key
     */
    String G_JWT_PAYLOAD_KEY = "payload";


    /**
     * JWT存储权限前缀
     */
    String G_JWT_AUTHORITY_PREFIX = "ROLE_";

    /**
     * JWT存储权限属性
     */
    String G_JWT_AUTHORITIES_KEY = "authorities";

    String G_JWT_USER_ID_KEY = "g-user_id";

    /**
     * 组属性
     */
    String G_JWT_USER_NICKNAME_KEY = "g-user_nickname";

    String G_JWT_USER_ACCOUNT_KEY = "g-user_account";

    String G_JWT_GROUP_KEY = "g-group_id";
}
