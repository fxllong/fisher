package com.fisher.tsc.msg.common;


public enum PublicEnum {
    YES("是"),

    NO("否");

    /** 描述 */
    private String desc;

    private PublicEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getCode() {
        return this.name();
    }

}
