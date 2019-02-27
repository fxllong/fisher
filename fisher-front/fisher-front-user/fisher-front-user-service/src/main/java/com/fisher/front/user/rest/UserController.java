package com.fisher.front.user.rest;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.fisher.common.util.IpUtil;
import com.fisher.common.util.ResponseUtil;
import com.fisher.common.vo.UserTokenInfo;
import com.fisher.front.user.model.MallUser;
import com.fisher.front.user.token.JwtUtils;
import com.fisher.front.user.vo.UserInfo;
import com.fisher.front.user.vo.WxLoginInfo;
import com.fisher.front.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fanxinglong
 * @create 2018-12-29 22:42
 **/
@RestController
@RequestMapping("wechat")
public class UserController {

    @Autowired
    private WxMaService wxService;

    @Autowired
    private UserService userService;

    /**
     * 微信登录
     *
     * @param wxLoginInfo 请求内容，{ code: xxx, userInfo: xxx }
     * @param request     请求对象
     * @return 登录结果
     * TODO 这里可以改成restful风格接口，token做缓存处理
     */
    @PostMapping("user")
    public Object loginByWeixin(@RequestBody WxLoginInfo wxLoginInfo, HttpServletRequest request) {
        //@RequestBody 会自动接收前端json对象参数并复制到对象中
        String code = wxLoginInfo.getCode();
        UserInfo userInfo = wxLoginInfo.getUserInfo();
        //如果为空说明传参错误
        if (code == null || userInfo == null) {
            return ResponseUtil.badArgument();
        }
        String sessionKey = null;
        String openId = null;
        try {
            //根据code获取openId和sessionKey
            WxMaJscode2SessionResult result = this.wxService.getUserService().getSessionInfo(code);
            sessionKey = result.getSessionKey();
            openId = result.getOpenid();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果sessionKey和openId为空，则说明获取失败
        if (sessionKey == null || openId == null) {
            return ResponseUtil.fail();
        }
        //根据openId查询出对应的用户
        MallUser user = userService.queryByOid(openId);
        //如果用户为空，则说明数据库中不存在，则插入数据
        if (user == null) {
            user = new MallUser();
            user.setUsername(openId);
            user.setPassword(openId);
            user.setWeixinOpenid(openId);
            user.setAvatar(userInfo.getAvatarUrl());
            user.setNickname(userInfo.getNickName());
            user.setGender(userInfo.getGender());
            user.setUserLevel((byte) 0);
            user.setStatus((byte) 0);
            user.setLastLoginTime(LocalDateTime.now());
            user.setLastLoginIp(IpUtil.client(request));
            userService.add(user);
            // 新用户发送注册优惠券
            //couponAssignService.assignForRegister(user.getId());
        } else {
            //说明用户已经存在
            user.setLastLoginTime(LocalDateTime.now());
            user.setLastLoginIp(IpUtil.client(request));
            //如果修改方法返回值为0，则说明修改失败
            if (userService.updateById(user) == 0) {
                return ResponseUtil.updatedDataFailed();
            }
        }
        // token
        UserTokenInfo u1 = new UserTokenInfo(user.getId(),user.getUsername());
        String token = null;
        try {
             token = JwtUtils.generateToken(u1,60*1000);
            LocalDateTime update = LocalDateTime.now();
            LocalDateTime expire = update.plusDays(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<Object, Object> result = new HashMap<Object, Object>();
        result.put("token", token);
        result.put("tokenExpire", 60*1000);
        result.put("userInfo", userInfo);
        return ResponseUtil.ok(result);
    }

    @GetMapping("/findById")
    public ResponseEntity<MallUser> queryUserById(@RequestParam("userId")Integer userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }


}
