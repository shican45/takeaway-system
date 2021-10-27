package com.example.permissioncommon;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.*;
import org.apache.tomcat.util.codec.binary.Base64;

public class JWTUtils {

    /**
     * jwt 加密解密密钥(可自行填写)
     */
    private static final String JWT_SECRET = "myScrect";

    private static final long JWT_EXPIRE_TIME = 30*24*60*60;

    /**
     * 通过用户信息和过期时间生成Jwt
     * @param ttlMillis 过期时间
     * @return token
     */
    public static String createJwt(String account, String password) {

        //自定义payload的claim信息
        Map<String, Object> claims = new HashMap<>(8);
        claims.put("account", account);
        claims.put("password", password);
        // builder.claim("account", "admin");

        // 签名算法 HS256，即jjwt已经封装header中需要的算法名称
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        SecretKey secretKey = generalKey();
        // 生成Jwt的时间，即签发时间
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + JWT_EXPIRE_TIME;;
        //构建Jwt
        JwtBuilder builder = Jwts.builder()
                            //jwt的签发者
                            .setIssuer("shican")
                            //jwt的签发时间
                            .setIssuedAt(new Date(nowMillis))
                            //设置过期时间，需要大于签发时间
                            .setExpiration(new Date(expMillis))
                            //添加载荷内容
                            .setClaims(claims)
                            //设置签名使用的签名算法和签名使用的秘钥
                            .signWith(signatureAlgorithm,secretKey);
        String token = builder.compact();
        return token;
    }

    /**
     * 由字符串生成加密key
     *
     * @return
     */
    public static SecretKey generalKey() {
        String stringKey = JWT_SECRET;
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 解析jwt，解析时若过期会抛出ExpiredJwtException异常
     * @param jwt token
     * @return jwt对象
     */
    public static Claims parseJwt(String jwt){
        //解析jwt
        JwtParser parser = Jwts.parser();
        //签名秘钥，和生成的签名的秘钥一模一样
        SecretKey key = generalKey();

        Claims claims;
        try {
            //获取解析后的对象
            claims = Jwts.parser()
                    //设置签名秘钥，和生成的签名的秘钥一模一样
                    .setSigningKey(key)
                    //设置需要解析的jwt
                    .parseClaimsJws(jwt)
                    .getBody();

        } catch (Exception e) {
            claims = null;
        }//设置需要解析的jwt
        return claims;
    }
}
