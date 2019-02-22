package com.fisher.common.enums;

/**
 * @description: 用户状态枚举
 */
public enum OperationStatusEnum {

    SUCCESS("0", "成功"),
    FAIL("1","失败");


    private String code;

    private String message;

    OperationStatusEnum(String code, String message) {
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
