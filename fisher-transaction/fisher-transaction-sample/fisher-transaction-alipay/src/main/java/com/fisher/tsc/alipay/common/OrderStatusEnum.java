package com.fisher.tsc.alipay.common;


public enum OrderStatusEnum {

    INIT("初始化"),
    SUCCESS("成功"),
    ;

    private String desc;

    OrderStatusEnum(String desc) {
        this.desc = desc;
    }

    public String desc(){
        return desc;
    }
    public String value(){
        return this.name();
    }

}
