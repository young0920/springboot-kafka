package com.young.springbootkafka.controller;

import com.young.springbootkafka.dao.User;
import com.young.springbootkafka.exception.BizException;
import com.young.springbootkafka.exception.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户Controller
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/3 11:03
 */
@RestController
@Slf4j
@RequestMapping(value = "/api")
public class UserController {

    @PostMapping("/user")
    public ResultBody<Boolean> insert(@RequestBody User user) {
        log.info("开始新增...");
        //如果姓名为空就手动抛出一个自定义的异常！
        if(user.getName()==null){
            throw  new BizException("-1","用户姓名不能为空！");
        }
        return ResultBody.success(true);
    }

    @PutMapping("/user")
    public ResultBody<Boolean> update(@RequestBody User user) {
        log.info("开始更新...");
        //这里故意造成一个空指针的异常，并且不进行处理
        String str=null;
        str.equals("111");
        return ResultBody.success(true);
    }

    @DeleteMapping("/user")
    public ResultBody<Boolean> delete(@RequestBody User user)  {
        log.info("开始删除...");
        //这里故意造成一个异常，并且不进行处理
        Integer.parseInt("abc123");
        return ResultBody.success(true);
    }

    @GetMapping("/user")
    public ResultBody<List<User>> findByUser(User user) {
        log.info("开始查询...");
        List<User> userList =new ArrayList<>();
        User user2=new User();
        user2.setId(1);
        user2.setName("xuwujing");
        user2.setAge(18);
        userList.add(user2);
        return ResultBody.success(userList);
    }

}
