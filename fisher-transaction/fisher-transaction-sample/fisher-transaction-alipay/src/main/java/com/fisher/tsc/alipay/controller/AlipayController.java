package com.fisher.tsc.alipay.controller;


import com.fisher.tsc.alipay.client.LtsMessageClient;
import com.fisher.tsc.alipay.pojo.AlipayTradeOrder;
import com.fisher.tsc.alipay.service.IAlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("capital")
public class AlipayController {

    @Autowired
    IAlipayService iCapitalService;
    @Autowired
    LtsMessageClient ltsMessageClient;

    @PostMapping("tranferToBalanceTreasure/{amount}")
    public ResponseEntity tranferToBalanceTreasure(@PathVariable BigDecimal amount){
        Long userId = 201914L;
        String messageId = iCapitalService.tranferToBalanceTreasure(userId, amount);
        //异常测试，抛个异常
//        int i = 1/0;
//         throw new NullPointerException("出现了空指针异常");
        //确认提交消息 通知余额宝进行加款
        ltsMessageClient.confirmAndSendMessage(messageId);
        return ResponseEntity.ok("success");
    }

    @PostMapping("balanceTreasureSuccess/{orderNo}")
    public boolean balanceTreasureSuccess(@PathVariable String orderNo){
        iCapitalService.doOrderSuccess(orderNo);
        return true;
    }

    @GetMapping("queryOrderStatus/{orderNo}")
    public String queryOrderStatus(@PathVariable String orderNo){

        AlipayTradeOrder order = iCapitalService.getCapitalTradeOrderByOderNo(orderNo);
        if (order != null){
            return order.getStatus();
        }
        return null;
    }

    @GetMapping("/test")
    public String hello(){
        int i = 3/0;
        System.out.println("还在执行吗？==============================");
        return "hello";
    }



}
