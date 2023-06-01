package com.lynwood.g.base.soi.common.enums;

import com.lynwood.g.base.soi.common.model.IResultCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author： Lynwood
 */
@AllArgsConstructor
public enum ResultCode implements IResultCode, Serializable {

    /* ------------------------------------------------------------------ 一级宏观错误码:A(用户端错误) ---------------------- */
    A_USER_SIDE_ERROR("A00001", "用户端异常"),
    /* ---------------------------- 二级宏观错误码:A01(用户错误) ---------------------- */
    USER_ERROR("A01000", "用户异常"),
    USER_PASSWORD_ERROR("A01001", "用户名或密码错误"),
    USER_NOT_EXIST("A01002", "用户不存在"),
    USER_EXIST("A01003", "用户已存在"),

    /* ---------------------------- 二级宏观错误码:A02(客户端错误) ---------------------- */
    CLIENT_ERROR("A02000", "客户端异常"),
    CLIENT_AUTHENTICATION_FAILED("A02001", "客户端认证失败"),
    CLIENT_ACCESS_UNAUTHORIZED("A02002", "客户端未授权"),

    /* ---------------------------- 二级宏观错误码:A03(访问权限错误) ---------------------- */
    AUTH_ERROR("A03000", "访问权限异常"),
    AUTH_TOKEN_INVALID_OR_EXPIRED("A03001", "token非法或失效"),
    AUTH_TOKEN_ACCESS_FORBIDDEN("A03002", "token禁止访问"),
    AUTH_NO_PERMISSION("A03003", "未授权"),

    /* ---------------------------- 二级宏观错误码:A04(请求参数错误) ---------------------- */
    PARAM_ERROR("A04000", "请求参数错误"),
    PARAM_MISMATCH("A04001", "参数校验错误"),
    PARAM_BODY_CONVERT_FAIL("A04002", "参数包体转换错误"),
    FILE_TOO_BIG("A04003", "上传文件过大"),

    /* ------------------------------------------------------------------ 一级宏观错误码:B(业务执行错误) ---------------------- */
    B_EXECUTION_ERROR("B00001", "执行异常"),
    /* ---------------------------- 二级宏观错误码:B01(系统) ---------------------- */
    SYS_ERROR("B01001", "系统异常"),
    SYS_FLOW_LIMITING("B01002", "系统访问限流"),
    SYS_DEGRADATION("B01003", "系统功能降级"),

    /* ---------------------------- 二级宏观错误码:B02(业务) ---------------------- */
    BIZ_ERROR("B02001", "业务异常"),

    /* ------------------------------------------------------------------ 一级宏观错误码:C(三方服务错误) ---------------------- */
    C_COMPONENT_ERROR("C00001", "系统组件异常"),
    /* ---------------------------- 二级宏观错误码:C01(数据库功能) ---------------------- */
    DB_ERROR("C01001", "数据库异常"),
    DB_TABLE_NOT_EXIST("C01002","表不存在"),

    /* ---------------------------- 二级宏观错误码:C02(缓存器功能) ---------------------- */
    CACHE_ERROR("C02001", "缓存异常"),




    SUCCESS("000000", "操作成功");

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    private String code;

    private String msg;

    @Override
    public String toString() {
        return "{" +
                "\"code\":\"" + code + '\"' +
                ", \"msg\":\"" + msg + '\"' +
                '}';
    }

}
