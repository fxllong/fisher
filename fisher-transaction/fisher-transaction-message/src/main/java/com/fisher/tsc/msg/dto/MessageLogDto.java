package com.fisher.tsc.msg.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;


@Data
public class MessageLogDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "修改者")
    private String editor;

    @ApiModelProperty(value = "创建者")
    private String creater;

    @ApiModelProperty(value = "消息内容")
    private HashMap<String,Object> messageBodyMap;

    @ApiModelProperty(value = "事件类型")
    private String eventType;

    public MessageLogDto(String eventType) {
        this.messageBodyMap = new HashMap();
        this.eventType = eventType;
    }

    public MessageLogDto put(String key,Object value){
        messageBodyMap.put(key,value);
        return this;
    }

}
