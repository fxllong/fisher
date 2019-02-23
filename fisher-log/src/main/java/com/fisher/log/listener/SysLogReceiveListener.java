package com.fisher.log.listener;

import com.fisher.common.constants.MqQueueNameConstant;
import com.fisher.common.dto.SysLogDTO;
import com.fisher.log.model.entity.SysLog;
import com.fisher.log.service.SysLogService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * 监听日志存储请求
 */
@Slf4j
@Component
public class SysLogReceiveListener {

    @Autowired
    private SysLogService sysLogService;


    /**
     * 日志队列消费端，存数据库
     * @param sysLogDTO
     * @param channel
     * @param message
     */
    @RabbitHandler
    @RabbitListener(queues = MqQueueNameConstant.SYS_LOG_QUEUE)
    public void handler(SysLogDTO sysLogDTO, Channel channel, Message message) throws IOException {
        log.info("系统日志消费端成功消费信息：sysLog={}", sysLogDTO);
        // 确认消息接受
        SysLog sysLog = new SysLog();
        BeanUtils.copyProperties(sysLogDTO, sysLog);
        sysLog.setCreateTime(new Date());
        sysLogService.save(sysLog);
    }


}
