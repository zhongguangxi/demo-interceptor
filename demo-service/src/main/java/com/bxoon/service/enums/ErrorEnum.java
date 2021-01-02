package com.bxoon.service.enums;


import lombok.Getter;

@Getter
public enum ErrorEnum {
    VALID_ERROR("1092", "参数校验失败");
    private String code;
    private String message;

    ErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}