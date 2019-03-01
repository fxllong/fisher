package com.fisher.tsc.personal.listener;

import com.fisher.tsc.personal.service.IBalanceTreasureService;
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
    IBalanceTreasureService iBalanceTreasureService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "capitalToTreasure", durable = "true"),
            exchange = @Exchange(name = "capital.order",
                    type = ExchangeTypes.TOPIC,
                    ignoreDeclarationExceptions = "true"),
            key = {"capitalToTreasure"}
    ))
    public void listenCapitalOrder(String messageBody) {
        log.info("BanlanceTreasureListener listenCapitalOrder:{}",messageBody);
        iBalanceTreasureService.dealWithTranferFromCapitalMessage(messageBody);
    }

}
