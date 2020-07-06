package com.young.springbootkafka.userdemo;

import com.young.springbootkafka.SpringbootKafkaApplication;
import com.young.springbootkafka.pojo.User;
import com.young.springbootkafka.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 类注释
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/6 13:23
 */
@SpringBootTest(classes = SpringbootKafkaApplication.class)
@RunWith(SpringRunner.class)
public class UserDemo {

    @Autowired
    private UserService userService;

    @Test
    public void insertBatchUser() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(String.valueOf(i + 2));
            user.setUsername("young" + i);
            user.setPassword("young" + i);
            user.setRealname("young" + i);
            userList.add(user);
        }
        userService.insertBatchUser(userList);
    }

    @Test
    public void updateBatchUser() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(String.valueOf(i + 2));
            user.setUsername("young" + i+2);
            user.setPassword("young" + i+2);
            user.setRealname("young" + i+2);
            userList.add(user);
        }
        userService.updateBatchUser(userList);
    }

    @Test
    public void selectBatchUser() {
        List<String> userList = new ArrayList<>();
        userList.add("2");
        userList.add("3");
        userList.add("4");

        userService.deleteBatchUser(userList);
    }
}