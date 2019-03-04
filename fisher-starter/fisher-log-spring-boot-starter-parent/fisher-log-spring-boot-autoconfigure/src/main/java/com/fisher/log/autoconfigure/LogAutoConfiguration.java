package com.fisher.log.autoconfigure;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(SysLogAspect.class)
public class LogAutoConfiguration {


    @Bean
    @ConditionalOnMissingBean(SysLogAspect.class)
    public SysLogAspect sysLogAspect() {
        return new SysLogAspect();
    }

}
