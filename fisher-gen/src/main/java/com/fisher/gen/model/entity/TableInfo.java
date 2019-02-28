package com.fisher.gen.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("information_schema.tables")
public class TableInfo {

    /**
     * 表名
     */
    @TableId
    private String tableName;

    /**
     * 数据库引擎名
     */
    private String engine;

    /**
     * 表注释
     */
    private String tableComment;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
