package com.fisher.common.enums;

/**
 * @description: 响应信息code枚举
 */
public enum  ResponseCodeEnum {

    SUCCESS(0, "success"),

    NOT_LOGIN(-1,"need login"),

    FAIL(-1,"fail"),

    PERMISSION_DEFINED(2,"permission defined");


    private Integer code;

    private String message;

    ResponseCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
