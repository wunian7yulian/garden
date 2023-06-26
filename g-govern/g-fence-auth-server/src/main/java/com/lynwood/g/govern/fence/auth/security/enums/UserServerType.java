package com.lynwood.g.govern.fence.auth.security.enums;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.HashSet;


/**
 * @Author Lynwood
 * @Date 2023/6/26
 * @Version 1.0
 */
@Getter
public enum UserServerType {

    SYS_USER("0","系统用户","g-sys");
    private final String code;

    private final String name;


    private final String prefix;

    UserServerType(String code, String name, String prefix) {
        this.code = code;
        this.name = name;
        this.prefix = prefix;
    }

    public static UserServerType getUserServerTypeByClient(@NotNull String client) {
        UserServerType result = null;
        for (UserServerType type : UserServerType.values()) {
            if (client.startsWith(type.getPrefix())) {
                result = type;
                break;
            }
        }
        return result;
    }

}
