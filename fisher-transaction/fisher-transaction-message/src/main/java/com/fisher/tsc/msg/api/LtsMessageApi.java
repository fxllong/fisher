package com.fisher.tsc.msg.api;

import com.fisher.tsc.msg.dto.MessageLogDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface LtsMessageApi {


    @PostMapping("message/saveMessageWaitingConfirm")
    String  saveMessageWaitingConfirm(@RequestBody MessageLogDto messageLogDto);

    @PostMapping("message/confirmAndSendMessage/{messageId}")
    boolean confirmAndSendMessage(@PathVariable("messageId") String messageId);

    @PostMapping("message/consumerSuccess/{messageId}")
    boolean consumerSuccess(@PathVariable("messageId") String messageId);
}
