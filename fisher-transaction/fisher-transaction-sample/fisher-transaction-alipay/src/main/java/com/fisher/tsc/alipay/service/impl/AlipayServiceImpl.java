package com.fisher.tsc.alipay.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fisher.tsc.alipay.client.AlipayMessageClient;
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
    AlipayAccountMapper alipayAccountMapper;
    @Autowired
    AlipayTradeOrderMapper alipayTradeOrderMapper;

    @Autowired
    IdWorker idWorker;

    @Autowired
    AlipayMessageClient alipayMessageClient;

    @Override
    @Transactional
    public String transferAlipayToPersonalBalance(Long userId, BigDecimal amount) {
        //查询用户账户资金
        //1.创建订单
        AlipayAccount alipayAccount = alipayAccountMapper.queryCapitalAccountByUserId(userId);
        alipayAccount.transferOut(amount);//扣减额度
        String remark = "个人账户单次转入";
        AlipayTradeOrder alipayTradeOrder = new AlipayTradeOrder();
        alipayTradeOrder.setAmount(amount.negate());
        alipayTradeOrder.setUserId(userId);
        alipayTradeOrder.setOrderNo(String.valueOf(idWorker.nextId()));
        alipayTradeOrder.setStatus(OrderStatusEnum.INIT.value());
        alipayTradeOrder.setRemark(remark);
        alipayTradeOrder.setCreateTime(new Date());
        alipayTradeOrder.setUpdateTime(new Date());
        alipayTradeOrderMapper.insert(alipayTradeOrder);
        log.info("用户{}开始个人账户转账，生成的订单：{}",userId,alipayTradeOrder);
        //2.预发送消息
        MessageLogDto messageLogDto = new MessageLogDto(EventTypeEnum.ALIPAY_TO_PERSONAL.getCode());
        messageLogDto.put("userId",userId)//
                .put("orderNo",alipayTradeOrder.getOrderNo())//
                .put("amount",amount);//
        String messageId = alipayMessageClient.saveMessageWaitingConfirm(messageLogDto);
        //3.更新资金账户额度  mybatisplus自带的乐观锁
        alipayAccount.setUpdateTime(new Date());
        alipayAccountMapper.updateById(alipayAccount);
        return messageId;
    }

    @Override
    public void doOrderSuccess(String orderNo) {
        AlipayTradeOrder alipayTradeOrder = alipayTradeOrderMapper.queryAlipayTradeOrderByOrderNo(orderNo);
        alipayTradeOrder.setUpdateTime(new Date());
        alipayTradeOrder.setStatus(OrderStatusEnum.SUCCESS.value());
        alipayTradeOrderMapper.update(alipayTradeOrder,
                new UpdateWrapper<AlipayTradeOrder>().eq("order_no",orderNo));
    }

    @Override
    public AlipayTradeOrder getCapitalTradeOrderByOderNo(String orderNo) {
        return alipayTradeOrderMapper.queryAlipayTradeOrderByOrderNo(orderNo);
    }


}
