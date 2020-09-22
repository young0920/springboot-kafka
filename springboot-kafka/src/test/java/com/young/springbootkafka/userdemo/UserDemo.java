package com.young.springbootkafka.userdemo;

import com.young.springbootkafka.SpringbootKafkaApplication;
import com.young.springbootkafka.pojo.User;
import com.young.springbootkafka.service.IMinioService;
import com.young.springbootkafka.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
public class UserDemo {

    @Autowired
    private UserService userService;

    @Autowired
    private IMinioService minioService;

    @Test
    public void getDate() throws IOException {
        File file=new File("/Users/young/Desktop/Java.pdf");
        InputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), inputStream);
        //上传文件
        //String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
        String url = minioService.uploadSuffix(multipartFile.getBytes(), "pdf");
        System.out.println(url);
    }

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