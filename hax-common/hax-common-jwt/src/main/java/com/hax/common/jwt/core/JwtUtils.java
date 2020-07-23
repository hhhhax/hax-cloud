package com.hax.common.jwt.core;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.hax.common.core.exception.GlobalException;
import com.hax.common.core.exception.ServiceException;
import com.hax.common.core.utils.Base64ConvertUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import static com.hax.common.core.enums.GlobalErrorCodeConstants.CREATE_TOKEN_ERROR;
import static com.hax.common.core.enums.GlobalErrorCodeConstants.TOKEN_EXPIRED_ERROR;
import static com.hax.common.core.enums.GlobalErrorCodeConstants.VERIFY_TOKEN_ERROR;
import static com.hax.common.jwt.constants.JwtConstants.*;

/**
 * @Author: hax
 * @Date: 2020/7/16
 * @company: yoe
 */
@Slf4j
public class JwtUtils {

    /**
     * JWT 自定义密钥 我这里写死的
     */
    private static final String SECRET_KEY = "hax-cloud";

    /**
     * JWT 过期时间值 这里写死和公众号网页授权一致7200秒，也就是2小时  改为一个月259200,30天
     */
    public static final long EXPIRE_TIME = 2592000;


    /**
     * JWT 过期时间值 这里写死和公众号网页授权一致2592000秒，也就是30天   2个月
     */
    public static final long REFRESH_EXPIRE_TIME = 518400;


    /**
     * 注 : 这里的token会被缓存到redis中,用作为二次验证
     * redis里面缓存的时间应该和jwt token的过期时间设置相同
     *
     * @param userId 用户id
     * @param type   用户类型
     * @param ip     请求ip
     * @return 返回 jwt token
     */
    public static String createRefreshToken(String userId, String type, String ip) {
        try {
            //1 . 加密算法进行签名得到token
            // 帐号加JWT私钥加密
            String secret = userId + Base64ConvertUtil.decode(SECRET_KEY);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 此处过期时间是以毫秒为单位，所以乘以1000
            Date date = new Date(System.currentTimeMillis() + REFRESH_EXPIRE_TIME * 1000);
            return JWT.create()
                    .withClaim(USER_ID, userId)
                    .withClaim(USER_TYPE, type)
                    .withClaim(LOGIN_IP, ip)
                    .withExpiresAt(date)  //JWT 配置过期时间的正确姿势
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            log.error("JWTToken加密出现UnsupportedEncodingException异常:" + e.getMessage());
            throw new GlobalException(CREATE_TOKEN_ERROR);
        }
    }


    /**
     * 注 : 这里的token会被缓存到redis中,用作为二次验证
     * redis里面缓存的时间应该和jwt token的过期时间设置相同
     *
     * @param userId  用户id
     * @param type    用户类型
     * @param refresh 刷新的token
     * @param ip      请求ip
     * @return 返回 jwt token
     */
    public static String createAccessToken(String userId, String type, String refresh, String ip) {
        try {
            //1 . 加密算法进行签名得到token
            // 帐号加JWT私钥加密
            String secret = userId + Base64ConvertUtil.decode(SECRET_KEY);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 此处过期时间是以毫秒为单位，所以乘以1000
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME * 1000);
            return JWT.create()
                    .withClaim(USER_ID, userId)
                    .withClaim(USER_TYPE, type)
                    .withClaim(REFRESH_TOKEN, refresh)
                    .withClaim(LOGIN_IP, ip)
                    .withExpiresAt(date)  //JWT 配置过期时间的正确姿势
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            log.error("JWTToken加密出现UnsupportedEncodingException异常:" + e.getMessage());
            throw new ServiceException(CREATE_TOKEN_ERROR);
        }
    }

    /**
     * /**
     * 校验token是否正确
     * <p>
     * 对token进行解密，解密成功则 继续流程
     *
     * @param token 密钥
     * @return 返回是否校验通过
     */
    public static boolean verifyToken(String token) {
        try {
            // 帐号加JWT私钥解密
            String secret = getUserIdByToken(token) + Base64ConvertUtil.decode(SECRET_KEY);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            verifier.verify(token);
            return true;
        } catch (TokenExpiredException e) { //捕捉到任何异常都视为校验失败
            log.info(" TOKEN:{},过期异常:{}", token, e.getMessage());
            throw new GlobalException(TOKEN_EXPIRED_ERROR);
        } catch (Exception e) {
            log.error("JWTToken认证解密出现异常:{}", e.getMessage());
            throw new GlobalException(VERIFY_TOKEN_ERROR);
        }
    }

    /**
     * 根据Token获取UserId
     */
    public static String getUserIdByToken(String token) {
        return JWT.decode(token).getClaim(USER_ID).asString();
    }

    /**
     * 根据Token获取UserType
     */
    public static String getUserTypeByToken(String token) {
        return JWT.decode(token).getClaim(USER_TYPE).asString();
    }

    /**
     * 根据Token获取UserIp
     */
    public static String getUserIpByToken(String token) {
        return JWT.decode(token).getClaim(LOGIN_IP).asString();
    }

    /**
     * 根据Token获取refresh
     */
    public static String getRefreshByToken(String token) {
        return JWT.decode(token).getClaim(REFRESH_TOKEN).asString();
    }


}
