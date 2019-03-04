package com.fisher.tsc.msg.common;


public enum MessageStatusEnum {

    WAITING_CONFIRM("待确认"),

    SENDING("发送中");

    /** 描述 */
    private String desc;

    private MessageStatusEnum(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }
    public String getCode() {
        return this.name();
    }
}
