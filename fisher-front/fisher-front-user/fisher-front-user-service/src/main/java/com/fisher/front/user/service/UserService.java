package com.fisher.front.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fisher.front.user.mapper.MallUserMapper;
import com.fisher.front.user.model.MallUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author fanxinglong
 * @create 2019-01-17 10:26
 **/
@Service
public class UserService {

    @Autowired
    private MallUserMapper userMapper;

    public MallUser queryByOid(String openId) {
        MallUser user = new MallUser();
        QueryWrapper queryWrapper = new QueryWrapper<>(user);
        queryWrapper.eq(true,"weixin_openid","openId").eq("deleted",false);
        return userMapper.selectOne(queryWrapper);
    }

    public void add(MallUser user) {
        user.setAddTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
    }

    public int updateById(MallUser user) {
        user.setUpdateTime(LocalDateTime.now());
        return userMapper.updateById(user);
    }

    public MallUser findById(Integer id) {
        return userMapper.selectById(id);
    }
}
