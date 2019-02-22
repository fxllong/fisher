package com.fisher.common.enums;

import lombok.Getter;


public enum  SmsMessageChannnelEnum {

    /**
     * 腾讯云
     */
    TENCENT_CLOUD("smsTencentCloudMessageHandler", "腾讯云");

    @Getter
    String code;

    @Getter
    String desc;

    private SmsMessageChannnelEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
