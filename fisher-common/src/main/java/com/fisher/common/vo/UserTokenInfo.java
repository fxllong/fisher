package com.fisher.common.vo;

import lombok.Data;

/**
 * 用户信息
 */
@Data
public class UserTokenInfo {

    private Integer id;

    private String username;

    public UserTokenInfo(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

}