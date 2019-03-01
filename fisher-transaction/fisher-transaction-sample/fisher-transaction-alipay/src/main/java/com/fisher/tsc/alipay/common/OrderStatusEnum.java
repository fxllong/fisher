package com.fisher.tsc.alipay.common;

/**
 * @author suzhe
 * @date 2019/1/4
 */
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
