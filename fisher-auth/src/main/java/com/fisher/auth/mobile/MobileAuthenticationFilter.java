package com.fisher.auth.mobile;

import com.fisher.common.constants.SecurityConstants;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 手机验证码登录filter
 */
public class MobileAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private String mobileParamter = SecurityConstants.SPRING_SECURITY_MOBILE_KEY;
    private String codeParamter = SecurityConstants.SPRING_SECURITY_CODE_KEY;


    private boolean postOnly = true;

    public MobileAuthenticationFilter() {
        super(SecurityConstants.SPRING_SECURITY_MOBILE_TOKEN_URL);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }

        String mobile = obtainMobile(request);
        String code = obtainCode(request);

        if (mobile == null) {
            mobile = "";
        }

        if (code == null) {
            code = "";
        }

        mobile = mobile.trim();
        code = code.trim();

        MobileAuthenticationToken authRequest = new MobileAuthenticationToken(
                mobile, code);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    private String obtainCode(HttpServletRequest request) {
        return request.getParameter(codeParamter);

    }

    private String obtainMobile(HttpServletRequest request) {
        return request.getParameter(mobileParamter);
    }

    protected void setDetails(HttpServletRequest request,
                              MobileAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }


    public String getMobileParamter() {
        return mobileParamter;
    }

    public void setMobileParamter(String mobileParamter) {
        Assert.hasText(mobileParamter, "mobileParamter parameter must not be empty or null");
        this.mobileParamter = mobileParamter;
    }

    public String getCodeParamter() {
        return codeParamter;
    }

    public void setCodeParamter(String codeParamter) {
        Assert.hasText(codeParamter, "codeParamter parameter must not be empty or null");
        this.codeParamter = codeParamter;
    }

    public boolean isPostOnly() {
        return postOnly;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }
}
