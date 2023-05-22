package com.lynwood.g.base.soi.common.enums.types;

import lombok.Getter;

/**
 * AE 优化师  销售  媒介   和各角色主管
 */
@Getter
public enum RoleType {

    SELF(0, "自己", "SELF#", "creator_id"),

    ADMIN(1, "系统管理员", "DEFAULT#", "creator_id"),

    BOSS(2, "企业管理员", "BOSS#", "creator_id"),
    ;

    private final Integer code;
    private final String desc;
    private final String codePreFix;
    private final String defaultField;

    RoleType(Integer code, String desc, String codePreFix, String defaultField) {
        this.code = code;
        this.desc = desc;
        this.codePreFix = codePreFix;
        this.defaultField = defaultField;
    }
}
