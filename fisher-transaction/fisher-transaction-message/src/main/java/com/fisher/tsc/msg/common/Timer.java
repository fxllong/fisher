package com.fisher.tsc.msg.common;

import com.fisher.tsc.msg.service.IMessageLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@EnableScheduling
public class Timer {

    @Autowired
    IMessageLogService iMessageLogService;
    /**
     *每30秒执行一次，处理创建时间在1分钟中前，处于等待状态的消息
     */
    @Scheduled(cron = "0/30 * * * * ?")
    public void doBatchHandleWaitingMessage(){
        log.info("doBatchHandleWaitingMessage ....");
        try {
            iMessageLogService.doBatchHandleWaitingMessage();
        }catch (Exception e){
            log.error("doBatchHandleWaitingMessage error:",e);
        }

    }

    /**
     *每30秒执行一次，处理创建时间在1分钟中前，处于发送状态的消息
     */
    @Scheduled(cron = "0/30 * * * * ?")
    public void doBatchHandleSendingMessage(){
        log.info("doBatchHandleWaitingMessage ....");
        try {
            iMessageLogService.doBatchHandleSendingMessage();
        }catch (Exception e){
            log.error("doBatchHandleWaitingMessage error:",e);
        }

    }

}
