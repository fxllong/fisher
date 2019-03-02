package com.fisher.tsc.msg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fisher.common.exception.FisherException;
import com.fisher.common.exception.MessageExceptionEnum;
import com.fisher.tsc.msg.common.*;
import com.fisher.tsc.msg.dto.EventTypeEnum;
import com.fisher.tsc.msg.mapper.MessageLogMapper;
import com.fisher.tsc.msg.pojo.MessageLog;
import com.fisher.tsc.msg.service.IMessageEventHandler;
import com.fisher.tsc.msg.service.IMessageLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@Service
@Slf4j
public class MessageLogServiceImpl extends ServiceImpl<MessageLogMapper, MessageLog>
        implements IMessageLogService, InitializingBean {

    @Autowired
    MessageLogMapper messageLogMapper;

    @Override
    public String saveMessageWaitingConfirm(MessageLog messageLog) {
        messageLog.setStatus(MessageStatusEnum.WAITING_CONFIRM.name());
        messageLog.setDead(PublicEnum.NO.getCode());
        messageLog.setCreateTime(new Date());
        messageLog.setUpdateTime(new Date());
        boolean saveFlag = save(messageLog);
        if (saveFlag){
            return messageLog.getMessageId();
        }
        return null;
    }

    @Override
    public boolean confirmAndSendMessage(String messageId) {
        MessageLog messageLog = messageLogMapper.queryMessageLogByMessageId(messageId);
        if (messageLog != null){
            String messageBody = messageLog.getMessageBody();
            String eventType = messageLog.getEventType();
            IMessageEventHandler iMessageEventHandler = handlers.get(eventType);//获取该事件对应的处理器
            if (iMessageEventHandler != null){
                iMessageEventHandler.sendMsg(messageLog.getMessageId(),messageBody);//发送消息
                messageLog.setStatus(MessageStatusEnum.SENDING.name());
                updateById(messageLog);//更新消息的状态为发送中
                return true;
            }else{
                log.warn("confirmAndSendMessage iMessageEventHandler not exist：{}",messageLog);
            }
        }else{
            log.warn("messageLog not exist:{}",messageId);
        }
        return false;
    }

    @Override
    public void confirmConsumeSuccess(String messageId) {
        MessageLog messageLog = messageLogMapper.queryMessageLogByMessageId(messageId);
        if (messageLog == null){
            throw new RuntimeException("未找到该消息");
        }
        IMessageEventHandler iMessageEventHandler = handlers.get(messageLog.getEventType());
        if (iMessageEventHandler == null){
            throw new RuntimeException("未找到该事件对应的处理器");
        }
        iMessageEventHandler.confirmConsumeSuccess(messageLog);
    }

    @Override
    public void doBatchHandleWaitingMessage() {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, -1);//当前时间减去1分钟

        IPage<MessageLog> iPage = messageLogMapper.selectPage(new Page<MessageLog>(1, 50),
                new QueryWrapper<MessageLog>()
                        .eq("status", MessageStatusEnum.WAITING_CONFIRM.getCode())//
                        .le("create_time",nowTime.getTime())
        );
        List<MessageLog> records = iPage.getRecords();
        records.stream().forEach(item -> {
            String eventType = item.getEventType();
            IMessageEventHandler iMessageEventHandler = handlers.get(eventType);
            if (iMessageEventHandler == null){
                throw new RuntimeException("未找到该事件对应的处理器");
            }
            iMessageEventHandler.doHandleWaitingMessage(item);
        });
    }

    @Override
    public void doBatchHandleSendingMessage() {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, -1);//当前时间减去1分钟

        IPage<MessageLog> iPage = messageLogMapper.selectPage(new Page<MessageLog>(1, 50),
                new QueryWrapper<MessageLog>()
                        .eq("status", MessageStatusEnum.SENDING.getCode())//
                        .eq("dead", PublicEnum.NO.getCode())
                        .le("create_time",nowTime.getTime())
        );
        List<MessageLog> records = iPage.getRecords();
        records.stream().forEach(item -> {
            String eventType = item.getEventType();
            IMessageEventHandler iMessageEventHandler = handlers.get(eventType);
            if (iMessageEventHandler == null){
                throw new RuntimeException("未找到该事件对应的处理器");
            }
            iMessageEventHandler.doHandleSendingMessage(item);
        });
    }

    @Override
    public void reSendMessage(MessageLog messageLog) {
        //检查消息数据的完整性
        this.checkEmptyMessage(messageLog);
        //更新消息发送次数
        messageLog.setMessageSendTimes(messageLog.getMessageSendTimes() + 1);
        messageLog.setUpdateTime(new Date());
        messageLogMapper.updateById(messageLog);
        String eventType = messageLog.getEventType();
        IMessageEventHandler iMessageEventHandler = handlers.get(eventType);//获取该事件对应的处理器
        //发送消息
        iMessageEventHandler.sendMsg(messageLog.getMessageId(),messageLog.getMessageBody());
    }

    @Override
    public void reSendMessageByMessageId(String messageId) {
        if (StringUtils.isEmpty(messageId)) {
            throw new FisherException();
        }
        MessageLog messageLog = messageLogMapper.queryMessageLogByMessageId(messageId);
        String eventType = messageLog.getEventType();
        IMessageEventHandler iMessageEventHandler = handlers.get(eventType);//获取该事件对应的处理器
        //发送消息
        iMessageEventHandler.reSendMsg(messageLog);
    }

    /**
     * 根据条件获取消息
     */
    @Override
    public Map<String, Object> getMsgByStateAndIsDeadAndIsTimeout(int page, int size, String messageId,String status, String dead) {
        Page<MessageLog> litemallpage = new Page<>(page, size);
        QueryWrapper<MessageLog> queryWrapper = new QueryWrapper<MessageLog>();
        if (!StringUtils.isEmpty(messageId)) {
            queryWrapper.eq("message_id",messageId);
        }
        if (!StringUtils.isEmpty(status)) {
            queryWrapper.eq("status",status);
        }
        if (!StringUtils.isEmpty(dead)) {
            queryWrapper.eq("dead",dead);
        }
        queryWrapper.last("order by id asc" );
        IPage<MessageLog> userIPage = messageLogMapper.selectPage(litemallpage, queryWrapper);
        Map<String,Object> result = new HashMap<>();
        result.put("total", userIPage.getTotal());
        result.put("page", page);
        result.put("size", size);
        result.put("body", userIPage.getRecords());
        return result;

    }


    private HashMap<String,IMessageEventHandler> handlers;

    @Override
    public void afterPropertiesSet() throws Exception {
        handlers = new HashMap<>();
        handlers.put(EventTypeEnum.CAPITAL_TO_TREASURE.getCode(),
                IOCUtil.getBean(MessageEventCapitalToTreasureHandler.class));
    }

    /**
     * 检查消息参数是否为空
     *
     */
    private void checkEmptyMessage(MessageLog messageLog) {
        if (messageLog == null) {
            throw new FisherException();
        }
        if (StringUtils.isEmpty(messageLog.getMessageId())) {
            throw new FisherException(MessageExceptionEnum.MESSAGE_ID_CANT_EMPTY);
        }
        if (StringUtils.isEmpty(messageLog.getMessageBody())) {
            throw new FisherException(MessageExceptionEnum.MESSAGE_BODY_CANT_EMPTY);
        }
//        if (StringUtils.isEmpty(messageLog.getConsumerQueue())) {
//            throw new FisherException(MessageExceptionEnum.QUEUE_CANT_EMPTY);
//        }
    }


}
