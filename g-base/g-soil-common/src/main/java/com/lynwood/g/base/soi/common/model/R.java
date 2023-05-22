package com.lynwood.g.base.soi.common.model;

import com.lynwood.g.base.soi.common.enums.ResultCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @author： Lynwood
 */
@Data
public class R<T> implements Serializable {

    private String code;

    private T data;

    private String msg;


    public boolean isSuccess() {
        return this.getCode() != null && ResultCode.SUCCESS.getCode().equals(this.getCode());
    }

    /* ------------------------------------------------------------------------------------------------------- 成功 ---------------------- */

    public static <T> R<T> ok() {
        return ok(null);
    }

    public static <T> R<T> ok(T data) {
        ResultCode rce = ResultCode.SUCCESS;
        return result(rce, data);
    }

    /* ------------------------------------------------------------------------------------------------------- 失败 ---------------------- */
    public static <T> R<T> failed(IResultCode resultCode) {
        return failed(resultCode, null);
    }

    public static <T> R<T> failed(IResultCode resultCode, String subMsg) {
        return result(resultCode, null, subMsg);
    }

    /* ------------------------------------------------------------------------------------------------------- 私有 ---------------------- */
    private static <T> R<T> result(IResultCode resultCode, T data) {
        return result(resultCode, data, null);
    }

    private static <T> R<T> result(IResultCode resultCode, T data, String subMsg) {
        R<T> result = new R<>();
        result.setCode(resultCode.getCode());
        /** 成功了不需要说什么,错了要是有不足就说失败原因 即是代码又是人生 **/
        if (ResultCode.SUCCESS == resultCode) {
            result.setData(data);
        } else {
            result.setMsg(result.getMsg());
            if(subMsg!=null) {
                result.setMsg(subMsg);
            }
        }
        return result;
    }
}
