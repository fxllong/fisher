package com.fisher.tsc.personal.listener;

import com.fisher.tsc.personal.service.IPersonalBalanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class BanlanceTreasureListener {

    @Autowired
    IPersonalBalanceService iPersonalBalanceService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "alipayToPersonal", durable = "true"),
            exchange = @Exchange(name = "alipay.order",
                    type = ExchangeTypes.TOPIC,
                    ignoreDeclarationExceptions = "true"),
            key = {"alipayToPersonal"}
    ))
    public void listenCapitalOrder(String messageBody) {
        log.info("PersonalBanlanceListener listenAlipayOrder:{}",messageBody);
        iPersonalBalanceService.dealWithTranferFromCapitalMessage(messageBody);
    }

}
