package com.fisher.tsc.alipay.service;

import com.fisher.tsc.alipay.pojo.AlipayTradeOrder;

import java.math.BigDecimal;


public interface IAlipayService {

    /**
     * 转账到余额宝
     * @param userId
     * @param amount
     */
    String tranferToBalanceTreasure(Long userId, BigDecimal amount);

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
