package com.lynwood.g.base.rock.web.exception;

import com.lynwood.g.base.soi.common.model.R;
import com.lynwood.g.base.soi.common.model.IResultCode;
import com.lynwood.g.base.soi.common.enums.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * @author： Lynwood
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 兜底异常
     *
     * @param e
     * @param <T>
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public <T> R<T> handleUnknownException(Exception e) {
        return this.getResult(ResultCode.SYS_ERROR, e, e.getMessage());
    }

    /**
     * 自定义业务异常业务异常
     *
     * @param e
     * @param <T>
     * @return
     */
    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(BizException.class)
    public <T> R<T> handleIllegalArgumentException(BizException e) {
        return this.getResult(e.getResultCode(), e, e.getMessage());
    }

    /**
     * 非法参数异常
     *
     * @param e
     * @param <T>
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(IllegalArgumentException.class)
    public <T> R<T> handleIllegalArgumentException(IllegalArgumentException e) {
        return this.getResult(ResultCode.PARAM_ERROR, e, e.getMessage());
    }

    /**
     * Valid 产出异常
     * 捕捉 MethodArgumentNotValidException 参数校验的异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public <T> R<T> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return this.getResult(ResultCode.PARAM_MISMATCH, e,
                e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.joining(",")));
    }

    /**
     * 捕捉 请求参数类型错误引起异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(TypeMismatchException.class)
    public <T> R<T> handleTypeMismatchException(TypeMismatchException e) {
        return this.getResult(ResultCode.PARAM_MISMATCH, e, e.getMessage());
    }

    /**
     * 捕捉 请求参数无法转换成对象引起异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public <T> R<T> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return this.getResult(ResultCode.PARAM_BODY_CONVERT_FAIL, e, e.getMessage());
    }

    private <T> R<T> getResult(IResultCode rc, Exception e, String message) {
        log.error("{}，异常原因：{}", rc.getMsg(), message);
        e.printStackTrace();
        return R.failed(rc, message);
    }
}
