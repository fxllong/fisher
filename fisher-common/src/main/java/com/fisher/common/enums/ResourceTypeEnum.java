package com.fisher.common.enums;

/**
 * @description: 资源类型枚举
 */
public enum  ResourceTypeEnum {
    MENU("0", "菜单"),
    BUTTON("1","按钮");


    private String code;

    private String message;

    ResourceTypeEnum(String code, String message) {
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
