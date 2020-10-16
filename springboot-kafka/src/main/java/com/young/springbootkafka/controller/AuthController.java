package com.young.springbootkafka.controller;

import com.young.springbootkafka.pojo.Users;
import com.young.springbootkafka.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * AuthController
 *
 * @Author yangbing
 * @Date 2020/10/15 4:44 下午
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private UserService userService;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody Users user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userService.insertToUsers(user);
        return "success";
    }
}