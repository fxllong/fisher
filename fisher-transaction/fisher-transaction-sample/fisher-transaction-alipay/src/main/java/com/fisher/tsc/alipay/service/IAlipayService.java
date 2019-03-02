package com.fisher.tsc.alipay.service;

import com.fisher.tsc.alipay.pojo.AlipayTradeOrder;

import java.math.BigDecimal;


public interface IAlipayService {

    /**
     * 转账到个人账户
     * @param userId
     * @param amount
     */
    String transferAlipayToPersonalBalance(Long userId, BigDecimal amount);

    /**
     * 订单成功的处理
     * @param orderNo
     */
    void doOrderSuccess(String orderNo);

    /**
     *
     * @param orderNo
     * @return
     */
    AlipayTradeOrder getCapitalTradeOrderByOderNo(String orderNo);
}
