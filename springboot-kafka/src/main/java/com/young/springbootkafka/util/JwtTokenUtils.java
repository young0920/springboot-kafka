package com.young.springbootkafka.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JwtUtils
 *
 * @Author yangbing
 * @Date 2020/10/15 3:09 下午
 */
public class JwtTokenUtils {
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    private static final String SECRET = "jwtsecretdemo";

    // 角色的key
    private static final String ROLE_CLAIMS = "role";

    private static final String USER_NAME = "username";

    // 过期时间为7天
    private static final long EXPIRATION = 604800L;

    // 创建token
    public static String createToken(String username, String role) {

        Map<String, Object> map = new HashMap<>();
        map.put(ROLE_CLAIMS, role);
        map.put(USER_NAME, username);

        return Jwts.builder()
                        .signWith(SignatureAlgorithm.HS512, SECRET)
                        .setClaims(map)
//                        .setIssuer(ISS)
//                        .setSubject(username)
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                        .compact();

    }

    // 从token中获取用户名
    public static String getUsername(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return claims.get(USER_NAME).toString();

    }

    // 获取用户角色
    public static String getUserRole(String token) {
        return (String) getTokenBody(token).get(ROLE_CLAIMS);
    }

    // 是否已过期
    public static boolean isExpiration(String token) {
        return getTokenBody(token).getExpiration().before(new Date());
    }

    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
