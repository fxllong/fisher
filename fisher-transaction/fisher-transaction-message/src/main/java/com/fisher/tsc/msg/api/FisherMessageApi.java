package com.fisher.tsc.msg.api;

import com.fisher.tsc.msg.dto.MessageLogDto;
import org.springframework.web.bind.annotation.*;


public interface FisherMessageApi {


    @PostMapping("message/saveMessageWaitingConfirm")
    String  saveMessageWaitingConfirm(@RequestBody MessageLogDto messageLogDto);

    @PostMapping("message/confirmAndSendMessage/{messageId}")
    boolean confirmAndSendMessage(@PathVariable("messageId") String messageId);

    @PostMapping("message/consumerSuccess/{messageId}")
    boolean consumerSuccess(@PathVariable("messageId") String messageId);

    @RequestMapping("message/reSendMessageByMessageId")
    boolean reSendMessageByMessageId(@RequestParam("messageId") String messageId);


}
