package com.fisher.common.enums;

/**
 * @description: 用户状态枚举
 */
public enum DataStatusEnum {

    NORMAL("0", "正常"),
    LOCK("1","删除");


    private String code;

    private String message;

    DataStatusEnum(String code, String message) {
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
