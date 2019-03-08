package com.fisher.tsc.msg.convert;

import com.fisher.tsc.msg.dto.MessageLogDto;

import com.fisher.tsc.msg.pojo.MessageLog;

import javax.annotation.Generated;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-03-08T15:32:27+0800",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_45 (Oracle Corporation)"

)

public class MessageConvertImpl implements MessageConvert {

    @Override

    public MessageLog dtoToPojo(MessageLogDto messageLogDto) {

        if ( messageLogDto == null ) {

            return null;
        }

        MessageLog messageLog = new MessageLog();

        return messageLog;
    }
}

