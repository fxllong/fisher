package com.fisher.common.enums;

/**
 * @description: 资源类型枚举
 */
public enum SysLogTypeEnum {
    LOGIN("0", "登录日志"),
    OPERATOR("1","操作日志");


    private String code;

    private String message;

    SysLogTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
