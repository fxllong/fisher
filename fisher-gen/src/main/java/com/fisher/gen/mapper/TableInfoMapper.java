package com.fisher.gen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fisher.gen.model.entity.TableInfo;
import com.fisher.gen.model.query.TableInfoQuery;
import org.apache.ibatis.annotations.Param;


public interface TableInfoMapper extends BaseMapper<TableInfo> {

    /**
     * 分页查询表信息
     * @param tableInfoQuery
     * @return
     */
    IPage<TableInfo> pageByQuery(TableInfoQuery tableInfoQuery);


    /**
     * 查询单个表信息
     * @param tableName
     * @return
     */
    TableInfo getOne(@Param("tableName") String tableName);

}
