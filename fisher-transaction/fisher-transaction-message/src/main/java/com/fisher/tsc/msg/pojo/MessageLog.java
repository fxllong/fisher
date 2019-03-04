package com.fisher.tsc.msg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("message_log")
@ApiModel(value="MessageLog对象", description="")
public class MessageLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "消息ID")
    private String messageId;

    @ApiModelProperty(value = "消息内容")
    private String messageBody;

    @ApiModelProperty(value = "事件类型")
    private String eventType;

    @ApiModelProperty(value = "消息重发次数")
    private Integer messageSendTimes;

    @ApiModelProperty(value = "是否死亡")
    private String dead;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    @ApiModelProperty(value = "修改者")
    private String editor;

    @ApiModelProperty(value = "创建者")
    private String creater;



}
