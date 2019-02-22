package com.fisher.back.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色资源关联表
 * </p>
 *
 * @author yukong
 * @since 2018-10-16
 */
@Data
@Accessors(chain = true)
public class SysRoleResource{

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer roleId;

    /**
     * 主键
     */
    private Integer resourceId;


}
