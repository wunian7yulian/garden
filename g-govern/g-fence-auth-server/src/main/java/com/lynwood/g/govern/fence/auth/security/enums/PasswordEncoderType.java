package com.lynwood.g.govern.fence.auth.security.enums;

import lombok.Getter;


/**
 * @author： Lynwood
 */
public enum PasswordEncoderType {

    BCRYPT("{bcrypt}","BCRYPT加密"),
    NOOP("{noop}","无加密明文");

    @Getter
    private final String prefix;



    PasswordEncoderType(String prefix, String desc){
        this.prefix=prefix;
    }

}
