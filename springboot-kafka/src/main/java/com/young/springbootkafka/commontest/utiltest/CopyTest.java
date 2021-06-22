package com.young.springbootkafka.commontest.utiltest;

import com.young.springbootkafka.pojo.User;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * CopyTest
 *
 * @Author young
 * @Date 2021/6/4
 */
public class CopyTest {
    public static void main(String[] args) {
        User u1 = new User();
        u1.setUsername("张三");
        u1.setTime(new Date());

        User u2 = new User();
        u2.setId("1111");
        u2.setPassword("lisi");
        u2.setRealname("wangwu");

        BeanUtils.copyProperties(u2,u1);

        System.out.println(u1);
        System.out.println(u2);

    }
}
