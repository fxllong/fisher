package com.fisher.tsc.personal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fisher.tsc.personal.pojo.PersonalTradeOrder;
import org.apache.ibatis.annotations.Select;


public interface PersonalBalanceTradeOrderMapper extends BaseMapper<PersonalTradeOrder> {
    @Select("SELECT * FROM personal_trade_order WHERE order_no = #{orderNo}")
    PersonalTradeOrder queryBalanceTreasureTradeOrderByOrderNo(String orderNo);

    @Select("SELECT * FROM personal_trade_order WHERE message_id = #{messageId}")
    PersonalTradeOrder queryBalanceTreasureTradeOrderByMessageId(String messageId);
}
