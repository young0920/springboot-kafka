package com.young.springbootkafka.service.authservice;

import com.alibaba.fastjson.JSON;
import com.young.springbootkafka.mapper.UsersMapper;
import com.young.springbootkafka.pojo.Users;
import com.young.springbootkafka.pojo.auth.JwtUser;
import com.young.springbootkafka.util.RedisUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by echisan on 2018/6/23
 *
 * @author young
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UsersMapper usersMapper;

    @Resource
    private RedisUtils redisUtils;

    /**
     * 过期时间七天
     */
    public static final long EXPIRE = 60 * 60 * 24 * 7L;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String key = "auth::" + username;
        boolean hasKey = redisUtils.hasKey(key);
        Users user;
        if (hasKey) {
            //获取缓存
            user = JSON.toJavaObject((JSON) redisUtils.get(key),Users.class);

        } else {
            user = usersMapper.findByUsername(username);
            if (user == null) {
                //仍需要细化处理
                throw new UsernameNotFoundException("该用户不存在");
            }

            redisUtils.set(key,user, EXPIRE);
        }
        return new JwtUser(user);
    }

}
