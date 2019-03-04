package com.fisher.tsc.personal.service.impl;

import com.fisher.tsc.msg.common.JsonUtils;
import com.fisher.tsc.personal.client.PersonalMessageClient;
import com.fisher.tsc.personal.common.OrderStatusEnum;
import com.fisher.tsc.personal.mapper.PersonalBalanceAccountMapper;
import com.fisher.tsc.personal.mapper.PersonalBalanceTradeOrderMapper;
import com.fisher.tsc.personal.pojo.OrderMessage;
import com.fisher.tsc.personal.pojo.PersonalBalanceAccount;
import com.fisher.tsc.personal.pojo.PersonalTradeOrder;
import com.fisher.tsc.personal.service.IPersonalBalanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;


@Service
@Slf4j
public class PersonalBalanceServiceImpl implements IPersonalBalanceService {


    @Autowired
    PersonalBalanceAccountMapper balanceTreasureAccountMapper;
    @Autowired
    PersonalBalanceTradeOrderMapper personalBalanceTradeOrderMapper;
    @Autowired
    PersonalMessageClient personalMessageClient;
    @Override
    public void dealWithTranferFromCapitalMessage(String message) {
        OrderMessage orderMessage = JsonUtils.toBean(message, OrderMessage.class);
        String messageId = orderMessage.getMessageId();
        PersonalTradeOrder oderBalanceTreasureTradeOrder = personalBalanceTradeOrderMapper.queryBalanceTreasureTradeOrderByMessageId(messageId);
        if(oderBalanceTreasureTradeOrder == null){//根据messageId去查询订单，如果不存在，做生成订单，增加个人账户额度
            PersonalTradeOrder balanceTreasureTradeOrder = new PersonalTradeOrder();
            balanceTreasureTradeOrder.setOrderNo(orderMessage.getOrderNo());
            balanceTreasureTradeOrder.setAmount(orderMessage.getAmount());
            balanceTreasureTradeOrder.setUserId(orderMessage.getUserId());
            balanceTreasureTradeOrder.setStatus(OrderStatusEnum.SUCCESS.code());
            balanceTreasureTradeOrder.setRemark("单次转入");
            balanceTreasureTradeOrder.setCreateTime(new Date());
            balanceTreasureTradeOrder.setUpdateTime(new Date());
            balanceTreasureTradeOrder.setMessageId(messageId);
            personalBalanceTradeOrderMapper.insert(balanceTreasureTradeOrder);
            //增加个人账户余额
            PersonalBalanceAccount balanceTreasureAccount = balanceTreasureAccountMapper.queryBalanceTreasureAccountByUserId(orderMessage.getUserId());
            balanceTreasureAccount.transferIn(orderMessage.getAmount());
            balanceTreasureAccount.setUpdateTime(new Date());
            balanceTreasureAccountMapper.updateById(balanceTreasureAccount);
        }
        //告知可靠消息服务，我已经消费成功。
        personalMessageClient.consumerSuccess(messageId);
    }
}
