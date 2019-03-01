package com.fisher.tsc.msg.dto;


public enum EventTypeEnum {

    CAPITAL_TO_TREASURE("余额转账到支付宝");
    /** 描述 */
    private String desc;
    private String code;

    private EventTypeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }


    public String getCode(){
        return this.name();
    }


}
