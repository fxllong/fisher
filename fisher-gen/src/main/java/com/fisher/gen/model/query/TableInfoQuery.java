package com.fisher.gen.model.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fisher.gen.model.entity.TableInfo;
import lombok.Data;


@Data
public class TableInfoQuery extends Page<TableInfo> {

    private String tableName;


}
