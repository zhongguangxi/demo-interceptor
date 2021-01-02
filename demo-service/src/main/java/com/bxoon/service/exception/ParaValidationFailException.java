package com.bxoon.service.exception;

/**
 * 参数校验失败异常
 * @author GuangxiZhong
 */
public class ParaValidationFailException extends RuntimeException {
    private String code;

    public ParaValidationFailException() {
        super();
    }

    public ParaValidationFailException(String code, String msg) {
        super(msg);
        this.code=code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
