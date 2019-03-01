package com.fisher.tsc.personal.service.impl;

import com.fisher.tsc.msg.common.JsonUtils;
import com.fisher.tsc.personal.client.LtsMessageClient;
import com.fisher.tsc.personal.common.OrderStatusEnum;
import com.fisher.tsc.personal.mapper.BalanceTreasureAccountMapper;
import com.fisher.tsc.personal.mapper.BalanceTreasureTradeOrderMapper;
import com.fisher.tsc.personal.pojo.CapitalOrderMessage;
import com.fisher.tsc.personal.pojo.PersonalBalanceAccount;
import com.fisher.tsc.personal.pojo.PersonalTradeOrder;
import com.fisher.tsc.personal.service.IBalanceTreasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;


@Service
@Slf4j
public class BalanceTreasureServiceImpl implements IBalanceTreasureService {


    @Autowired
    BalanceTreasureAccountMapper balanceTreasureAccountMapper;
    @Autowired
    BalanceTreasureTradeOrderMapper balanceTreasureTradeOrderMapper;
    @Autowired
    LtsMessageClient ltsMessageClient;
    @Override
    public void dealWithTranferFromCapitalMessage(String message) {
        CapitalOrderMessage capitalOrderMessage = JsonUtils.toBean(message, CapitalOrderMessage.class);
        String messageId = capitalOrderMessage.getMessageId();
        PersonalTradeOrder oderBalanceTreasureTradeOrder = balanceTreasureTradeOrderMapper.queryBalanceTreasureTradeOrderByMessageId(messageId);
        if(oderBalanceTreasureTradeOrder == null){//根据messageId去查询订单，如果不存在，做生成订单，增加余额宝额度
            PersonalTradeOrder balanceTreasureTradeOrder = new PersonalTradeOrder();
            balanceTreasureTradeOrder.setOrderNo(capitalOrderMessage.getOrderNo());
            balanceTreasureTradeOrder.setAmount(capitalOrderMessage.getAmount());
            balanceTreasureTradeOrder.setUserId(capitalOrderMessage.getUserId());
            balanceTreasureTradeOrder.setStatus(OrderStatusEnum.SUCCESS.code());
            balanceTreasureTradeOrder.setRemark("单次转入");
            balanceTreasureTradeOrder.setCreateTime(new Date());
            balanceTreasureTradeOrder.setUpdateTime(new Date());
            balanceTreasureTradeOrder.setMessageId(messageId);
            balanceTreasureTradeOrderMapper.insert(balanceTreasureTradeOrder);
            //增加余额宝额度
            PersonalBalanceAccount balanceTreasureAccount = balanceTreasureAccountMapper.queryBalanceTreasureAccountByUserId(capitalOrderMessage.getUserId());
            balanceTreasureAccount.transferIn(capitalOrderMessage.getAmount());
            balanceTreasureAccount.setUpdateTime(new Date());
            balanceTreasureAccountMapper.updateById(balanceTreasureAccount);
        }
        //告知可靠消息服务，我已经消费成功。
        ltsMessageClient.consumerSuccess(messageId);
    }
}
