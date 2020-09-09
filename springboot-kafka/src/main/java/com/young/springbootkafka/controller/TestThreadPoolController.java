package com.young.springbootkafka.controller;
import java.util.Date;

import com.young.springbootkafka.pojo.Test;
import com.young.springbootkafka.service.ThreadPoolAsyncService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * 测试线程池异步请求
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/10 11:28
 */

@RestController
@Slf4j
@Api(tags = "线程池测试")
public class TestThreadPoolController {
    @Resource
    private ThreadPoolAsyncService threadPoolAsyncService;


    @ApiOperation("线程池测试-三个线程打印0-100")
    @GetMapping("/executor")
    public String submit() {
        log.info("start submit");

        //调用service层的任务
        Future<Boolean> booleanFuture1 = threadPoolAsyncService.executeAsync();
        Future<Boolean> booleanFuture2 =threadPoolAsyncService.executeAsync();
        Future<Boolean> booleanFuture3 =threadPoolAsyncService.executeAsync();

        log.info("end submit");
        return "success";
    }

    @PostMapping("testTime")
    public Test testTime(@RequestBody Test test){
        System.out.println(test);
        Test t = new Test();
        t.setTime1(new Date());
        t.setTime2(new Date());
        t.setTime3(new Date());
        return t;
    }

}
