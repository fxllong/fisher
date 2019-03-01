package com.fisher.tsc.msg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fisher.tsc.msg.common.PageResult;
import com.fisher.tsc.msg.pojo.MessageLog;

import java.util.Map;


public interface IMessageLogService extends IService<MessageLog> {
    /**
     * 预存储消息.
     */
    public String saveMessageWaitingConfirm(MessageLog messageLog);

    /**
     * 确认并发送消息.
     */
    public boolean confirmAndSendMessage(String messageId);

    /**
     * 确认消费成功
     * @param messageId
     * @return
     */
    public void confirmConsumeSuccess(String messageId);


    /**
     * 批量处理长久等待的消息
     */
    void doBatchHandleWaitingMessage();


    /**
     * 批量处理长久处于发送中状态的消息
     */
    void doBatchHandleSendingMessage();

    Map<String, Object> getMsgByStateAndIsDeadAndIsTimeout(int page, int size, String messageId, String status, String dead);

}
