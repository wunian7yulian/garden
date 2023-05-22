package com.lynwood.g.base.rock.web.utils;

import cn.hutool.core.util.ObjectUtil;
import com.lynwood.g.base.rock.web.exception.BizException;
import com.lynwood.g.base.soi.common.enums.ResultCode;

/**
// * @author： Lynwood
 */
public class AssertUtil {


    /**
     * 断言为空 支持各种类型
     */
    public static void empty(Object value, ResultCode msg) {
        isTrue(ObjectUtil.isEmpty(value), msg);
    }

    /**
     * 断言不为空,支持多种类型
     */
    public static void notEmpty(Object value, ResultCode msg) {
        isTrue(ObjectUtil.isNotEmpty(value), msg);
    }

    /**
     * 断言是否为真
     */
    public static void isTrue(boolean flag, ResultCode msg) {
        isFalse(!flag, msg);
    }

    /**
     * 断言是否为假
     */
    public static void isFalse(boolean flag, ResultCode msg) {
        if (flag == false) {
            return;
        }
        throw new BizException(msg);
    }

}