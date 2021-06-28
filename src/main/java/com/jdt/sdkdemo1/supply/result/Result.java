package com.jdt.sdkdemo1.supply.result;

import java.io.Serializable;
import java.util.Map;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: TODO
 * @date 2021/6/25 9:43
 */
public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private Throwable throwable;
    private T data;

    public static Result getSuccessResultVo() {
        return getResult(ResultCodeEnum.SUCCESS);
    }

    public static <T> Result getSuccessResultVo(T data) {
        return getResult(ResultCodeEnum.SUCCESS, data);
    }

    public static Result getFailureResultVo(Integer failureCode, String failureMessage) {
        return getResult(failureCode, failureMessage, null, null);
    }

    public static Result getFailureResultVo(Integer failureCode, String failureMessage, Throwable t) {
        return getResult(failureCode, failureMessage, null, t);
    }

    public static <T> Result getFailureResultVo(Integer failureCode, String failureMessage, T data) {
        return getResult(failureCode, failureMessage, data, null);
    }

    public static <T> Result getFailureResultVo(
            Integer failureCode, String failureMessage, T data, Throwable t) {
        return getResult(failureCode, failureMessage, data, t);
    }

    public static Result getResult(Integer code, String message) {
        return getResult(code, message, null, null);
    }

    public static Result getResult(ResultCodeEnum ResultCodeEnumVo) {
        return getResult(ResultCodeEnumVo.code(), ResultCodeEnumVo.msg(), null, null);
    }

    public static <T> Result getResult(ResultCodeEnum ResultCodeEnumVo, T data) {
        return getResult(ResultCodeEnumVo.code(), ResultCodeEnumVo.msg(), data, null);
    }

    public static Result getFailureResultVo(ResultCodeEnum ResultCodeEnumVo, Throwable t) {
        return getResult(ResultCodeEnumVo.code(), ResultCodeEnumVo.msg(), null, t);
    }

    @SuppressWarnings("unchecked")
    private static <T> Result getResult(Integer code, String message, T data, Throwable t) {
        Result ResultVo = new Result();
        ResultVo.setCode(code);
        ResultVo.setMessage(message);
        ResultVo.setData(data);
        ResultVo.setThrowable(t);
        return ResultVo;
    }

    private Result() {
    }

    public boolean getIsSuccess() {
        return is(ResultCodeEnum.SUCCESS);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public boolean is(ResultCodeEnum e) {
        return code != null && code.equals(e.code());
    }

    public void setEnum(ResultCodeEnum e) {
        setEnum(e, null);
    }

    public void setEnum(ResultCodeEnum e, Throwable throwable) {
        this.setCode(e.code());
        this.setMessage(e.msg());
        this.setThrowable(throwable);
    }

    public void setResultVo(Result<?> ResultVo) {
        this.setCode(ResultVo.getCode());
        this.setMessage(ResultVo.getMessage());
        this.setThrowable(ResultVo.getThrowable());
    }
}
