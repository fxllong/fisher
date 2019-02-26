package com.fisher.back.model.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fisher.back.model.entity.SysDict;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class SysDictQuery extends  Page<SysDict> {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 字典描述
     */
    private String desc;
    /**
     * 字典值
     */
    private String value;
    /**
     * 上层id  定义默认是-1
     */
    private Integer parentId;
    /**
     * 权重
     */
    private Integer sortOrder;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime modifyTime;
    /**
     * 是否删除 1-删除，0-未删除
     */
    private String delFlag;

}
