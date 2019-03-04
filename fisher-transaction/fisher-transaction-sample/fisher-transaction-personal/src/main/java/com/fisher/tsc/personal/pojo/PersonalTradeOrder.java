package com.fisher.tsc.personal.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@TableName("personal_trade_order")
@ApiModel(value="PersonalTradeOrder对象", description="")
public class PersonalTradeOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "交易订单号")
    private String orderNo;
    @ApiModelProperty(value = "消息id")
    private String messageId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "交易金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "交易状态")
    private String status;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


    @ApiModelProperty(value = "版本号")
    @Version
    private Integer version;

}
