package com.young.springbootkafka.controller;

import com.young.springbootkafka.pojo.User;
import com.young.springbootkafka.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * redis接口
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/7 19:47
 */
@RestController
@Slf4j
@RequestMapping(value = "/redis")
@Api(tags = "redis测试接口")
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "/hello/{id}")
    @ApiOperation("redis测试接口")
    public String hello(@PathVariable(value = "id") String id) {
        //查询缓存中是否存在
        boolean hasKey = redisUtils.hasKey(id);
        String str = "";
        if (hasKey) {
            //获取缓存
            Object object = redisUtils.get(id);
            log.info("从缓存获取的数据" + object);
            str = object.toString();
        } else {
            //从数据库中获取信息
            log.info("从数据库中获取数据");
            List<User> userList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                User user = new User();
                user.setId(String.valueOf(i + 2));
                user.setUsername("young" + i + 2);
                user.setPassword("young" + i + 2);
                user.setRealname("young" + i + 2);
                userList.add(user);
            }
            //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
            redisUtils.set(id, userList, 1000L);
            log.info("数据插入缓存" + str);
        }
        return str;
    }
}
