package com.fisher.common.base.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BaseService<T> extends IService<T> {

    /**
     * 分页条件查询
     * @param query
     * @return
     */
    IPage<T> pageByQuery(IPage<T> query);

}
