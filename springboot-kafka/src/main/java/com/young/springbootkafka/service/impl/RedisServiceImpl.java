package com.young.springbootkafka.service.impl;

import com.young.springbootkafka.pojo.User;
import com.young.springbootkafka.service.RedisService;
import com.young.springbootkafka.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * redis测试接口实现类
 * EQ 就是 EQUAL等于
 * NE就是 NOT EQUAL不等于
 * GT 就是 GREATER THAN大于
 * LT 就是 LESS THAN小于
 * GE 就是 GREATER THAN OR EQUAL 大于等于
 * LE 就是 LESS THAN OR EQUAL 小于等于
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/8 9:03
 */
@Service
@Slf4j
//全局什么 value 的值
@CacheConfig(cacheNames = "vvv")
public class RedisServiceImpl implements RedisService {

    @Resource
    RedisUtils redisUtils;

    private static Map<String, User> userList = new HashMap<>();

    static {
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(String.valueOf(i + 2));
            user.setUsername("young" + i + 2);
            user.setPassword("young" + i + 2);
            user.setRealname("young" + i + 2);
            userList.put("" + i + i, user);
        }
    }


/*    @Caching(
            cacheable = {
                    @Cacheable(*//*value = "emp",*//* key = "#lastName")
            },
            put = {
                    //Put一定是在执行方法之后调用，只要一个方法标了@CachePut，那么每次执行查		    询都会直接去查数据库，然后再将结果插入到缓存中，但是下次在用id查询的时候就不需要查询数据库了，直接从缓存中lookup->get(key)
                    @CachePut(*//*value = "emp",*//* key = "#result.id"),
                    @CachePut(*//*value = "emp",*//* key = "#result.email")
            }
    )*/

    /**
     * Cacheable将在执行方法之前( #result还拿不到返回值)判断condition，如果返回true，则查缓存；
     * LT 就是 LESS THAN小于
     *
     * @param id
     * @return
     */
    @Cacheable(/*value = "user",*/ key = "#id")
    @Override
    public User conditionFindById(String id) {
        return userList.get(id);
    }

    /**
     * CachePut将在执行完方法后（#result就能拿到返回值了）判断condition，如果返回true，则放入缓存；
     * <p>
     * NE就是 NOT EQUAL不等于
     *
     * @param user
     * @return
     */
    @CachePut(/*value = "user",*/ key = "#user.id", condition = "#result.username ne 'zhang'")
    @Override
    public User conditionSave(User user) {
        user.setId("yangshuaishuai");
        user.setUsername("yangshuaishuai");
        user.setPassword("yangshuaishuai");
        user.setRealname("yangshuaishuai");
        return user;
    }

    /**
     * CachePut将在执行完方法后（#result就能拿到返回值了）判断unless，如果返回false，则放入缓存；（即跟condition相反）
     * EQ 就是 EQUAL等于
     *
     * @param user
     * @return
     */
    @Override
    @CachePut(/*value = "user",*/ key = "#user.id", unless = "#result.username eq 'zhang'")
    public User conditionSave2(User user) {
        user.setId("yangshuaishuai2");
        user.setUsername("yangshuaishuai2");
        user.setPassword("yangshuaishuai2");
        user.setRealname("yangshuaishuai2");
        return user;
    }

    /**
     * CacheEvict， beforeInvocation=false表示在方法执行之后调用（#result能拿到返回值了）；且判断condition，如果返回true，则移除缓存；
     *
     * @param user
     * @return
     */
    @CacheEvict(/*value = "user",*/ key = "#user.id", beforeInvocation = false, condition = "#result.username ne 'yangshuaishuai2'")
    @Override
    public User conditionDelete(User user) {
        user.setId("yangshuaishuai");
        user.setUsername("yangshuaishuai");
        user.setPassword("yangshuaishuai");
        user.setRealname("yangshuaishuai");
        return user;
    }
}
