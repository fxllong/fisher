package com.fisher.common.base.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;


public interface BaseMapper<T> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {


    /**
     * 分页查询
     * @param query 分页查询条件
     * @return 分页查询结果
     */
    IPage<T> pageByQuery(IPage<T> query);
}
