package com.fisher.tsc.alipay.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fisher.tsc.alipay.pojo.AlipayAccount;
import org.apache.ibatis.annotations.Select;


public interface AlipayAccountMapper extends BaseMapper<AlipayAccount> {

    @Select("select * from alipay_account where user_id = #{userId}")
    public AlipayAccount queryCapitalAccountByUserId(Long userId);
}
