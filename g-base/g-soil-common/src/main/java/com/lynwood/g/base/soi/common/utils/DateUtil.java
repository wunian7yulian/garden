package com.lynwood.g.base.soi.common.utils;

import cn.hutool.core.date.format.FastDateFormat;

import java.util.Date;

/**
 * @Author Lynwood
 * @Date 2023/4/25
 * @Version 1.0
 */
public class DateUtil extends cn.hutool.core.date.DateUtil {

    public static String getCurrentStr(FastDateFormat format){
        return format.format(new Date());
    }




}
