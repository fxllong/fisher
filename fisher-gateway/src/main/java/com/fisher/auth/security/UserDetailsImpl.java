package com.fisher.auth.security;

import com.fisher.common.enums.UserStatusEnum;
import com.fisher.common.vo.SysRoleVo;
import com.fisher.common.vo.SysUserVo;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @description: security 用户对象
 * 本地测试，几个系统用的同一个redis，对象在一个系统中序列化存入redis，包路径com.fisher.auth.security.UserDetailsImpl；
 * 主要原因是因为key也是相同，在运行另一个系统时，发现这个key已经存在了，取出时，如果网关这个系统不存在com.fisher.auth.security.UserDetailsImpl这个类的话
 * 会报错redis序列化问题，com.fisher.auth.security.UserDetailsImpl找不到，并且前端会报跨域错误。
 * 由于两个对象的类所处的包路径不一致，反序列化失败，因而报找不到类错误。
 */

@Data
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = -2636609458742965698L;

    private Integer userId;
    private String username;
    private String password;
    private String status;
    private List<SysRoleVo> roleVos;




    public UserDetailsImpl(SysUserVo userVo) {
        this.userId = userVo.getUserId();
        this.username = userVo.getUsername();
        this.password = userVo.getPassword();
        this.status = userVo.getDelFlag();
        this.roleVos = userVo.getSysRoleVoList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        roleVos.forEach(role ->{
            authorityList.add(new SimpleGrantedAuthority(role.getRoleCode()));
        });
//        authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !StringUtils.equals(UserStatusEnum.LOCK.getCode(), status);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return StringUtils.equals(UserStatusEnum.NORMAL.getCode(), status);
    }
}
