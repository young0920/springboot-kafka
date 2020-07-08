package com.young.springbootkafka.service;

import com.young.springbootkafka.pojo.User;

/**
 * redis 测试接口
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
public interface RedisService {

    /**
     * Cacheable将在执行方法之前( #result还拿不到返回值)判断condition，如果返回true，则查缓存；
     * LT 就是 LESS THAN小于
     *
     * @param id
     * @return
     */
    User conditionFindById(String id);

    /**
     * CachePut将在执行完方法后（#result就能拿到返回值了）判断condition，如果返回true，则放入缓存；
     * <p>
     * NE就是 NOT EQUAL不等于
     *
     * @param user
     * @return
     */
    User conditionSave(User user);

    /**
     * CachePut将在执行完方法后（#result就能拿到返回值了）判断unless，如果返回false，则放入缓存；（即跟condition相反）
     * EQ 就是 EQUAL等于
     *
     * @param user
     * @return
     */
    User conditionSave2(User user);

    /**
     * CacheEvict， beforeInvocation=false表示在方法执行之后调用（#result能拿到返回值了）；且判断condition，如果返回true，则移除缓存；
     *
     * @param user
     * @return
     */
    User conditionDelete(User user);

}
