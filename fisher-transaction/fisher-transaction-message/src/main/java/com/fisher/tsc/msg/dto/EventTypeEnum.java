package com.fisher.tsc.msg.dto;


public enum EventTypeEnum {

    ALIPAY_TO_PERSONAL("支付宝转账到个人");
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
