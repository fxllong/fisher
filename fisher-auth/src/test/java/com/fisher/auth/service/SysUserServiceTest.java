package com.fisher.auth.service;

import com.fisher.common.vo.SysUserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceTest {

    @Autowired
    private SysUserService sysUserService;

//    @Test
//    public void findByUsername() {
//        SysUserVo sysUserVo = sysUserService.loadUserByUsername("fisher");
//        System.out.println("=============="+sysUserVo.getUsername());
//    }

    @Test
    public void testPassword() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("adminFAN262553");
        System.out.println("=============="+password);
    }


}