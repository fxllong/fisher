package com.fisher.common.enums;

/**
 * @description: 用户状态枚举
 */
public enum  UserStatusEnum {

    /**
     * 正常
     */
    NORMAL("0", "正常"),

    /**
     * 锁定
     */
    LOCK("1","锁定");


    private String code;

    private String message;

    UserStatusEnum(String code, String message) {
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
