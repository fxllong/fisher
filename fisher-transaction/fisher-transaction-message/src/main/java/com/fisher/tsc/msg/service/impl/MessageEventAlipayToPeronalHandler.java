package com.fisher.tsc.msg.service.impl;

import com.fisher.tsc.msg.common.JsonUtils;
import com.fisher.tsc.msg.common.MessageStatusEnum;
import com.fisher.tsc.msg.common.PublicEnum;
import com.fisher.tsc.msg.mapper.MessageLogMapper;
import com.fisher.tsc.msg.pojo.MessageLog;
import com.fisher.tsc.msg.service.IMessageEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;


@Service
@Slf4j
public class MessageEventAlipayToPeronalHandler implements IMessageEventHandler {
    private final String EXCHANGE = "alipay.order";

    private final String ROUTING_KEY = "alipayToPersonal";

    private String baseUrl = "http://fisher-transaction-alipay-service/";//这里应该放在统一的服务地址配置类

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private MessageLogMapper messageLogMapper;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void sendMsg(String messageId, String messageBody) {
//        int i = 1/0;
        amqpTemplate.convertAndSend(EXCHANGE,ROUTING_KEY,messageBody);
    }

    @Override
    public void reSendMsg(MessageLog messageLog) {
        messageLog.setMessageSendTimes(messageLog.getMessageSendTimes()+1);
        messageLog.setUpdateTime(new Date());
        messageLogMapper.updateById(messageLog);
        //发送消息
        amqpTemplate.convertAndSend(EXCHANGE,ROUTING_KEY,messageLog.getMessageBody());
    }

    @Override
    public void confirmConsumeSuccess(MessageLog messageLog) {
        //通知账户余额服务更新订单状态
        Map<String, Object> messageMap = JsonUtils.toMap(messageLog.getMessageBody(), String.class, Object.class);
        String orderNo = (String) messageMap.get("orderNo");
        boolean success = restTemplate.postForObject(baseUrl + "alipay/personalBalanceSuccess/" + orderNo,null, Boolean.class);
        if (success){
            //删除本地消息表的消息
            messageLogMapper.deleteById(messageLog.getId());
        }
    }

    @Override
    public void doHandleWaitingMessage(MessageLog messageLog) {
        Map<String, Object> messageMap = JsonUtils.toMap(messageLog.getMessageBody(), String.class, Object.class);
        String orderNo = (String) messageMap.get("orderNo");
        String result = restTemplate.getForObject(baseUrl + "alipay/queryOrderStatus/" + orderNo, String.class);
        if ("INIT".equals(result)){//如果订单的状态为INIT 则该消息需要通知个人账户服务
            messageLog.setStatus(MessageStatusEnum.SENDING.getCode());
            messageLogMapper.updateById(messageLog);
            amqpTemplate.convertAndSend(EXCHANGE,ROUTING_KEY,messageLog.getMessageBody());
        }else{
            //删除本地消息表的消息。
            messageLogMapper.deleteById(messageLog.getId());
        }

    }

    @Override
    public void doHandleSendingMessage(MessageLog messageLog) {
        Integer messageSendTimes = messageLog.getMessageSendTimes();
        if (messageSendTimes > 5){
            messageLog.setDead(PublicEnum.YES.getCode());
        }
        messageLog.setMessageSendTimes(messageSendTimes + 1 );
        amqpTemplate.convertAndSend(EXCHANGE,ROUTING_KEY,messageLog.getMessageBody());
        messageLogMapper.updateById(messageLog);
    }


}
