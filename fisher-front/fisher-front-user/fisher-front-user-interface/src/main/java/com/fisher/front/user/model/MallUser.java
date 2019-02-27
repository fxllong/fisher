package com.fisher.front.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@TableName(value = "litemall_user")
public class MallUser {

    public static final Boolean NOT_DELETED = false;

    public static final Boolean IS_DELETED = true;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private Byte gender;

    private LocalDate birthday;

    private LocalDateTime lastLoginTime;

    private String lastLoginIp;

    private Byte userLevel;

    private String nickname;

    private String mobile;

    private String avatar;

    private String weixinOpenid;

    private Byte status;

    private LocalDateTime addTime;

    private LocalDateTime updateTime;

    private Boolean deleted;

}