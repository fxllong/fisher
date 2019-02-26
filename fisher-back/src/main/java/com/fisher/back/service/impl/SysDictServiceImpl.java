package com.fisher.back.service.impl;

import com.fisher.back.mapper.SysDictMapper;
import com.fisher.back.model.entity.SysDict;
import com.fisher.back.service.SysDictService;
import com.fisher.common.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class SysDictServiceImpl extends BaseServiceImpl<SysDictMapper, SysDict> implements SysDictService {
}
