package com.fisher.tsc.personal.common;


public enum OrderStatusEnum {

    INIT("初始化，未付款"),
    SUCCESS("成功"),
    ;

    private String desc;


    OrderStatusEnum(String desc) {
        this.desc = desc;
    }

    public String desc(){
        return desc;
    }
    public String code(){
        return this.name();
    }

}
