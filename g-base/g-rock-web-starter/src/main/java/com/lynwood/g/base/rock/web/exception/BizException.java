package com.lynwood.g.base.rock.web.exception;

import com.lynwood.g.base.soi.common.model.IResultCode;
import com.lynwood.g.base.soi.common.enums.ResultCode;
import lombok.Getter;

/**
 * @author： Lynwood
 */
@Getter
public class BizException extends RuntimeException {

    public IResultCode resultCode = ResultCode.SYS_ERROR;

    public String subMsg;

    public BizException() {
    }

    public BizException(IResultCode errorCode) {
        super(errorCode.getMsg());
        this.resultCode = errorCode;
    }

    public BizException(IResultCode errorCode, String subMsg) {
        super(errorCode.getMsg());
        this.resultCode = errorCode;
        this.subMsg = subMsg;
    }

    public BizException(IResultCode errorCode, Throwable cause) {
        super(errorCode.getMsg(), cause);
        this.resultCode = errorCode;
        this.subMsg = cause.getMessage();
    }
}
