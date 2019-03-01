package com.fisher.tsc.alipay.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fisher.tsc.alipay.client.LtsMessageClient;
import com.fisher.tsc.alipay.common.IdWorker;
import com.fisher.tsc.alipay.common.OrderStatusEnum;
import com.fisher.tsc.alipay.mapper.AlipayAccountMapper;
import com.fisher.tsc.alipay.mapper.AlipayTradeOrderMapper;
import com.fisher.tsc.alipay.pojo.AlipayAccount;
import com.fisher.tsc.alipay.pojo.AlipayTradeOrder;
import com.fisher.tsc.alipay.service.IAlipayService;
import com.fisher.tsc.msg.dto.EventTypeEnum;
import com.fisher.tsc.msg.dto.MessageLogDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.Date;


@Service
@Slf4j
public class AlipayServiceImpl implements IAlipayService {

    @Autowired
    AlipayAccountMapper capitalAccountMapper;
    @Autowired
    AlipayTradeOrderMapper capitalTradeOrderMapper;

    @Autowired
    IdWorker idWorker;

    @Autowired
    LtsMessageClient ltsMessageClient;

    @Override
    @Transactional
    public String tranferToBalanceTreasure(Long userId, BigDecimal amount) {
        //查询用户账户资金
        //1.创建订单
        AlipayAccount capitalAccount = capitalAccountMapper.queryCapitalAccountByUserId(userId);
        capitalAccount.transferOut(amount);//扣减额度
        String remark = "余额宝单次转入";
        AlipayTradeOrder capitalTradeOrder = new AlipayTradeOrder();
        capitalTradeOrder.setAmount(amount.negate());
        capitalTradeOrder.setUserId(userId);
        capitalTradeOrder.setOrderNo(String.valueOf(idWorker.nextId()));
        capitalTradeOrder.setStatus(OrderStatusEnum.INIT.value());
        capitalTradeOrder.setRemark(remark);
        capitalTradeOrder.setCreateTime(new Date());
        capitalTradeOrder.setUpdateTime(new Date());
        capitalTradeOrderMapper.insert(capitalTradeOrder);
        log.info("用户{}开始余额宝转账，生成的订单：{}",userId,capitalTradeOrder);
        //2.预发送消息
        MessageLogDto messageLogDto = new MessageLogDto(EventTypeEnum.CAPITAL_TO_TREASURE.getCode());
        messageLogDto.put("userId",userId)//
                .put("orderNo",capitalTradeOrder.getOrderNo())//
                .put("amount",amount);//
        String messageId = ltsMessageClient.saveMessageWaitingConfirm(messageLogDto);
        //3.更新资金账户额度  mybatisplus自带的乐观锁
        capitalAccount.setUpdateTime(new Date());
        capitalAccountMapper.updateById(capitalAccount);
        return messageId;
    }

    @Override
    public void doOrderSuccess(String orderNo) {
        AlipayTradeOrder capitalTradeOrder = capitalTradeOrderMapper.queryCapitalTradeOrderByOrderNo(orderNo);
        capitalTradeOrder.setUpdateTime(new Date());
        capitalTradeOrder.setStatus(OrderStatusEnum.SUCCESS.value());
        capitalTradeOrderMapper.update(capitalTradeOrder,
                new UpdateWrapper<AlipayTradeOrder>().eq("order_no",orderNo));
    }

    @Override
    public AlipayTradeOrder getCapitalTradeOrderByOderNo(String orderNo) {
        return capitalTradeOrderMapper.queryCapitalTradeOrderByOrderNo(orderNo);
    }


}
