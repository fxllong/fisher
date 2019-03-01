package com.fisher.tsc.alipay.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fisher.tsc.alipay.pojo.AlipayTradeOrder;
import org.apache.ibatis.annotations.Select;


public interface AlipayTradeOrderMapper extends BaseMapper<AlipayTradeOrder> {
    @Select("SELECT * FROM alipay_trade_order WHERE order_no = #{orderNo}")
    AlipayTradeOrder queryCapitalTradeOrderByOrderNo(String orderNo);
}
