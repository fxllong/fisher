package com.fisher.front.user.api;


import com.fisher.front.user.model.MallUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @date 2018/9/22
 */
public interface UserApi {

    @GetMapping("wechat/findById")
    public MallUser queryUserById(@RequestParam("userId") Integer userId);

}
