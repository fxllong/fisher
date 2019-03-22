package com.fisher.back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fisher.back.mapper.SysOauthClientDetailsMapper;
import com.fisher.back.model.entity.SysOauthClientDetails;
import com.fisher.back.service.SysOauthClientDetailsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * oauth2客户端资源认证表 服务实现类
 * </p>
 *
 */
@Service
public class SysOauthClientDetailsServiceImpl extends ServiceImpl<SysOauthClientDetailsMapper, SysOauthClientDetails> implements SysOauthClientDetailsService {

}
