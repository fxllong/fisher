package com.fisher.tsc.msg.service;


import com.fisher.tsc.msg.pojo.MessageLog;

public interface IMessageEventHandler {

    /**
     * 发送消息
     * @param messageId
     * @param messageBody
     */
    void sendMsg(String messageId, String messageBody);

    /**
     * 成功消费某消息
     * @param messageLog
     */
    void confirmConsumeSuccess(MessageLog messageLog);

    /**
     * 处理长久等待的消息
     * @param messageLog
     */
    void doHandleWaitingMessage(MessageLog messageLog);

    /**
     * 处理长久处于发送中的消息
     * @param messageLog
     */
    void doHandleSendingMessage(MessageLog messageLog);

}
