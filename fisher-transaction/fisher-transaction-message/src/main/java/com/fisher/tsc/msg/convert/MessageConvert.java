package com.fisher.tsc.msg.convert;


import com.fisher.tsc.msg.dto.MessageLogDto;
import com.fisher.tsc.msg.pojo.MessageLog;
import org.mapstruct.factory.Mappers;



@org.mapstruct.Mapper
public interface MessageConvert {
    MessageConvert MAPPER = Mappers.getMapper(MessageConvert.class);

    MessageLog dtoToPojo(MessageLogDto messageLogDto);

}
