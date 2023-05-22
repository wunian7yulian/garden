package com.lynwood.g.base.soi.common.enums.types;

import lombok.Getter;

/**
 * @Author Lynwood
 * @Date 2023/4/25
 * @Version 1.0
 */
@Getter
public enum GeneralNumType {
    NORMAL(0, "通用", "N");

    private final Integer code;
    private final String desc;

    private final String prefix;

    GeneralNumType(Integer code, String desc, String prefix) {
        this.code = code;
        this.desc = desc;
        this.prefix = prefix;
    }
}
