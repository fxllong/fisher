package com.fisher.auth.mobile;

import com.fisher.auth.security.UserDetailsImpl;
import com.fisher.auth.service.SysUserService;
import com.fisher.common.constants.SecurityConstants;
import com.fisher.common.vo.SysUserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


/**
 * 手机验证码登录逻辑实现
 */
public class MobileAuthenticationProvider implements AuthenticationProvider {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    private RedisTemplate<String, String> redisTemplate;

    private SysUserService sysUserService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        MobileAuthenticationToken mobileAuthenticationToken = (MobileAuthenticationToken) authentication;
        String mobile = mobileAuthenticationToken.getPrincipal().toString();
        String realCode = redisTemplate.opsForValue().get(SecurityConstants.REDIS_CODE_PREFIX + mobile);
        String inputCode = authentication.getCredentials().toString();
        // 判断手机的验证码是否存在
        if (realCode == null) {
            logger.debug("登录失败，当前手机号验证码不存在或者已经过期");
            throw new BadCredentialsException("登录失败，验证码不存在");
        }
        // 判断是否验证码跟redis中存的验证码是否正确
        if(!inputCode.equalsIgnoreCase(realCode)) {
            logger.debug("登录失败，您输入的验证码不正确");

            throw new BadCredentialsException("登录失败，验证码不正确");
        }
        SysUserVo sysUserVo = sysUserService.loadUserByMobile(mobile);
        if(sysUserVo == null) {
            logger.debug("登录失败，用户不存在");
            throw new UsernameNotFoundException("登录失败, 手机号码不存在");
        }

        UserDetailsImpl userDetails = new UserDetailsImpl(sysUserVo);
        // 重新构造token  登录成功
        MobileAuthenticationToken authenticationToken = new MobileAuthenticationToken(userDetails, inputCode, userDetails.getAuthorities());
        authenticationToken.setDetails(mobileAuthenticationToken.getDetails());
        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return MobileAuthenticationToken.class.isAssignableFrom(authentication);
    }


    public RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public SysUserService getSysUserService() {
        return sysUserService;
    }

    public void setSysUserService(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }
}
