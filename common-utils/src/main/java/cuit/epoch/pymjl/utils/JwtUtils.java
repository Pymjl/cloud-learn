package cuit.epoch.pymjl.utils;

import com.google.common.io.BaseEncoding;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pymjl
 * @date 2022/1/19 21:49
 */
@Component
public class JwtUtils {
    private static long expiration;

    private static String jwtId;

    private static String jwtSecret;
    private static final int TIME_UNIT = 1000;

    /**
     * 创建JWT
     */
    public static String createJWT(Map<String, Object> claims, Long time) {
        //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Date now = new Date(System.currentTimeMillis());

        SecretKey secretKey = generalKey();
        //生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        //下面就是在为payload添加各种标准声明和私有声明了
        //这里其实就是new一个JwtBuilder，设置jwt的body
        JwtBuilder builder = Jwts.builder()
                //如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setClaims(claims)
                //设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setId(jwtId)
                //iat: jwt的签发时间
                .setIssuedAt(now)
                //设置签名使用的签名算法和签名使用的秘钥
                .signWith(signatureAlgorithm, secretKey);
        if (time >= 0) {
            long expMillis = nowMillis + time;
            Date exp = new Date(expMillis);
            //设置过期时间
            builder.setExpiration(exp);
        }
        return builder.compact();
    }


    /**
     * 验证jwt
     */
    public static Claims verifyJwt(String token) {
        //签名秘钥，和生成的签名的秘钥一模一样
        SecretKey key = generalKey();
        Claims claims;
        try {
            //得到DefaultJwtParser
            claims = Jwts.parser()
                    //设置签名的秘钥
                    .setSigningKey(key)
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            claims = null;
        }//设置需要解析的jwt
        return claims;
    }

    /**
     * 由字符串生成加密key
     *
     * @return SecretKey
     */
    public static SecretKey generalKey() {
        String stringKey = jwtSecret;
        byte[] encodedKey = BaseEncoding.base64().decode(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "HmacSHA256");
        return key;
    }

    /**
     * 根据userId和userName生成token
     */
    public static String generateToken(Long userId, String username) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("nickName", username);
        return createJWT(map, expiration * TIME_UNIT);
    }

    /**
     * 根据userName生成token
     */
    public static String generateToken(String username) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        return createJWT(map, expiration * TIME_UNIT);
    }

    @Value("${jwt.expiration:36000}")
    public void setTokenExpiredTime(long tokenExpiredTime) {
        JwtUtils.expiration = tokenExpiredTime;
    }

    @Value("${jwt.id:token}")
    public void setJwtId(String jwtId) {
        JwtUtils.jwtId = jwtId;
    }

    @Value("${jwt.secret:cuit.pymjl.epoch}")
    public void setJwtSecret(String jwtSecret) {
        JwtUtils.jwtSecret = jwtSecret;
    }

    public static long getExpiration() {
        return expiration;
    }

    public static String getJwtId() {
        return jwtId;
    }

    public static String getJwtSecret() {
        return jwtSecret;
    }
}
