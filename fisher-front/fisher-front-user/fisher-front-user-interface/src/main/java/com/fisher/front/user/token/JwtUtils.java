package com.fisher.front.user.token;


import com.fisher.common.vo.UserTokenInfo;
import com.fisher.front.user.utils.ObjectUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

/**
 * @author: li
 * @create: 2018-10-23
 **/
public class JwtUtils {

    /**
     * 私钥加密token
     *
     * @param userInfo      载荷中的数据
     * @param privateKey    私钥字节数组
     * @param expireMinutes 过期时间，单位秒
     * @return
     * @throws Exception
     */
    public static String generateToken(UserTokenInfo userInfo, int expireMinutes) throws Exception {
//        System.out.println("--------生成采用的key---"+secretKey);
        return Jwts.builder()
                .claim(JwtConstans.JWT_KEY_ID, userInfo.getId())
                .claim(JwtConstans.JWT_KEY_USER_NAME, userInfo.getUsername())
                .setExpiration(DateTime.now().plusMinutes(expireMinutes).toDate())
                .signWith(SignatureAlgorithm.HS256, "wqewqexcfdfweqwe323d")
                .compact();
    }

    /**
     * 由字符串生成加密key
     * @return
     */
//    public static SecretKey generalKey(String  secretKey){
////        String stringKey = "7786df7fc3a34e26a61c034d5ec8245d";//本地配置文件中加密的密文
//        byte[] encodedKey = Base64.decodeBase64(secretKey);//本地的密码解码[B@152f6e2
//        System.out.println(encodedKey);//[B@152f6e2
//        System.out.println(Base64.encodeBase64URLSafeString(encodedKey));//7786df7fc3a34e26a61c034d5ec8245d
//        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");// 根据给定的字节数组使用AES加密算法构造一个密钥，使用 encodedKey中的始于且包含 0 到前 leng 个字节这是当然是所有。（后面的文章中马上回推出讲解Java加密和解密的一些算法）
//        return key;
//    }


    /**
     * 公钥解析token
     *
     * @param token     用户请求中的token
     * @param publicKey 公钥字节数组
     * @return
     * @throws Exception
     */
    private static Jws<Claims> parserToken(String token, String secretKey) throws Exception {
        return Jwts.parser().setSigningKey("wqewqexcfdfweqwe323d")
                .parseClaimsJws(token);
    }

    /**
     * 获取token中的用户信息
     *
     * @param token     用户请求中的令牌
     * @param publicKey 公钥
     * @return 用户信息
     * @throws Exception
     */
    public static UserTokenInfo getInfoFromToken(String token) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, "wqewqexcfdfweqwe323d");
        Claims body = claimsJws.getBody();
        return new UserTokenInfo(
                ObjectUtils.toInt(body.get(JwtConstans.JWT_KEY_ID)),
                ObjectUtils.toString(body.get(JwtConstans.JWT_KEY_USER_NAME))
        );
    }
}