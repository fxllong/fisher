package com.fisher.tsc.console.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "fisher-transaction-service")
public interface TransactionMsgServiceClient {

    @RequestMapping(value="message/getMsgByStateAndIsDeadAndIsTimeout")
    Map<String, Object> getMsgByStateAndIsDeadAndIsTimeout(@RequestBody Map<String, Object> param);

    @PostMapping("message/reSendMessageByMessageId")
    void reSendMessageByMessageId(@RequestParam("messageId") String messageId);

}
