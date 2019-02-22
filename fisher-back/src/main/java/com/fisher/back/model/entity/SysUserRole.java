package com.fisher.back.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 */
@Data
@Accessors(chain = true)
public class SysUserRole{

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer userId;

    /**
     * 主键
     */
    private Integer roleId;


}
