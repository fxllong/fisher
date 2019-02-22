package com.fisher.common.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class SysUserVo {

    /**
     * 主键ID
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * qq号码
     */
    private String qq;

    /**
     * 微信号码
     */
    private String wechat;

    /**
     * 微博url
     */
    private String weibo;

    /**
     * 头像url
     */
    private String avatar;

    /**
     * qq openid
     */
    private String qqOpenid;

    /**
     * 微信openid
     */
    private String wechatOpenid;

    /**
     * 微博openid
     */
    private String weiboOpenid;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime modifyTime;

    /**
     * 是否删除 0-未删除 1-删除
     */
    private String delFlag;

    private List<SysRoleVo> sysRoleVoList;

}
