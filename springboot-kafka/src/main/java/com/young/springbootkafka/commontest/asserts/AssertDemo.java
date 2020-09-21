package com.young.springbootkafka.commontest.asserts;

import com.young.springbootkafka.pojo.User;
import com.young.springbootkafka.pojo.User2;
import org.springframework.util.Assert;

/**
 * AssertDemo
 *
 * @Author yangbing
 * @Date 2020/9/8 10:21 上午
 */
public class AssertDemo {
    public static void main(String[] args) {
        Assert.hasText(" xx", "不能为空");

        Assert.notNull("null", "不能为null");

        Assert.isNull(null, "shi");

        Assert.isInstanceOf(User.class, new User2(), "是");


    }
}
