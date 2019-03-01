package com.fisher.tsc.personal.pojo;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class CapitalOrderMessage {

    private Long userId;

    private BigDecimal amount;

    private String orderNo;

    private String messageId;
}
