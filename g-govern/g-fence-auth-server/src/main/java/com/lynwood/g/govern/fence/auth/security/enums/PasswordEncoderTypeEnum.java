package com.lynwood.g.govern.fence.auth.security.enums;

import lombok.Getter;


/**
 * @author： Lynwood
 */
public enum PasswordEncoderTypeEnum {

    BCRYPT("{bcrypt}","BCRYPT加密"),
    NOOP("{noop}","无加密明文");

    @Getter
    private final String prefix;



    PasswordEncoderTypeEnum(String prefix, String desc){
        this.prefix=prefix;
    }

}
