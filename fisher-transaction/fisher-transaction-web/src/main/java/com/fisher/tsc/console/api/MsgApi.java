package com.fisher.tsc.console.api;

import com.fisher.tsc.console.client.TransactionMsgServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/msg")
public class MsgApi {

    @Autowired
    private TransactionMsgServiceClient transactionMsgServiceClient;

    @RequestMapping("/getMsgByCondtion")
    public Map<String,Object> getMsgByStateAndIsDeadAndIsTimeout(@RequestBody Map<String,Object> param){

        return transactionMsgServiceClient.getMsgByStateAndIsDeadAndIsTimeout(param);
    }

    @PostMapping("/reSendMsg")
    public void getMsgByStateAndIsDeadAndIsTimeout(@RequestParam("messageId") String messageId){
        System.out.println(messageId+"===========");
        transactionMsgServiceClient.reSendMessageByMessageId(messageId);
    }


}
