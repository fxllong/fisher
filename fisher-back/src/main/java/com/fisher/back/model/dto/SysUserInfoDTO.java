package com.fisher.back.model.dto;

import com.fisher.back.model.entity.SysUser;
import lombok.Data;

import java.util.List;

@Data
public class SysUserInfoDTO {

    private SysUser sysUser;

    private List<String> roles;

    private List<String> permissions;
}
