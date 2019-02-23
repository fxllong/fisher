package com.fisher.log.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 操作日志表
 * </p>
 */
@Data
@Accessors(chain = true)
public class SysLog {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 服务名称
     */
    private String serviceId;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 请求方法
     */
    private String actionName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime modifyTime;

    /**
     * 执行时间
     */
    private Long time;

    /**
     * 操作IP地址
     */
    private String remoteAddr;
    /**
     * 请求URI
     */
    private String requestUri;

    private Integer status;







}
