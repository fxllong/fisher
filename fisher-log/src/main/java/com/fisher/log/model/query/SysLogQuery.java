package com.fisher.log.model.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fisher.log.model.entity.SysLog;
import lombok.Data;

@Data
public class SysLogQuery extends Page<SysLog> {


    /**
     * 主键
     */
    private Long id;

    /**
     * 日志类型
     */
    private String type;

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 操作状态 1 失败  0 成功
     */
    private String status;

    /**
     * 创建者
     */
    private String createBy;

}
