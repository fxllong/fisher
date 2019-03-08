package com.fisher.back.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 资源表(菜单与按钮)
 * </p>
 */
@Data
@Accessors(chain = true)
public class SysResource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源类型 0-菜单 1-按钮
     */
    private String type;

    /**
     * 前端url
     */
    private String path;

    /**
     * 按钮权限资源标识
     */
    private String permission;

    /**
     * 颜色
     */
    private String color;

    /**
     * 父资源id
     */
    private Integer parentId;

    /**
     * 图标
     */
    private String icon;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 排序权重
     */
    private Integer sort;

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


    /**
     * 后台请求url
     */
    private String url;


    /**
     * 请求方式
     */
    private String method;



}
