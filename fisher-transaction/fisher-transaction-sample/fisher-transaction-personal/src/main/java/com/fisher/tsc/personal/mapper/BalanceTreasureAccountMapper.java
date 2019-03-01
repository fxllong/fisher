package com.fisher.tsc.personal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fisher.tsc.personal.pojo.PersonalBalanceAccount;
import org.apache.ibatis.annotations.Select;


public interface BalanceTreasureAccountMapper extends BaseMapper<PersonalBalanceAccount> {

    @Select("SELECT * FROM `personal_balance_account` WHERE user_id=#{userId}")
    PersonalBalanceAccount queryBalanceTreasureAccountByUserId(long userId);
}
