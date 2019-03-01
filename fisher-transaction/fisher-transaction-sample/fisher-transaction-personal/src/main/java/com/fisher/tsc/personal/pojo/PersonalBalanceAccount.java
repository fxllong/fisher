package com.fisher.tsc.personal.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@TableName("personal_balance_account")
@Data
@ApiModel(value="PersonalBalanceAccount对象", description="")
public class PersonalBalanceAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private BigDecimal totalAmount;

    private Integer userId;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


    @ApiModelProperty(value = "版本号")
    @Version
    private Integer version;

    public void transferIn(BigDecimal amount){
        totalAmount = totalAmount.add(amount);
    }


}
