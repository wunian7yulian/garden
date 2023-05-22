package com.lynwood.g.base.soi.common.constants;
/**
 * @author： Lynwood
 */
public interface SecurityConstants {


    /**
     * Basic认证前缀
     */
    String BASIC_PREFIX = "Basic ";

    /**
     * 认证请求头key
     */
    String AUTHORIZATION_KEY = "Authorization";

    /**
     * JWT令牌前缀
     */
    String JWT_PREFIX = "Bearer ";

    /**
     * JWT载体key
     */
    String JWT_PAYLOAD_KEY = "payload";


    /**
     * JWT存储权限前缀
     */
    String JWT_AUTHORITY_PREFIX = "ROLE_";

    /**
     * JWT存储权限属性
     */
    String JWT_AUTHORITIES_KEY = "authorities";

    /**
     * 组属性
     */
    String JWT_GROUP_KEY = "group_id";

}
