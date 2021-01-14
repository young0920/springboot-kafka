package com.young.springbootkafka.controller;

import com.young.springbootkafka.annotation.NoRepeatSubmit;
import com.young.springbootkafka.constant.GlobalConstants;
import com.young.springbootkafka.constant.ResultBody;
import com.young.springbootkafka.util.ApiTokenUtils;
import com.young.springbootkafka.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * NoRepeatSubmitController
 *
 * @author yangbing
 * @date 2021/1/14 下午7:34
 */
@RestController
@RequestMapping("submit")
@Slf4j
public class NoRepeatSubmitController {

    @Resource
    private RedisUtils redisUtils;

    /**
     * 获取页面token
     *
     * @return
     */
    @GetMapping("token")
    public ResultBody<String> getToken() {
        String token = ApiTokenUtils.getToken();
        redisUtils.set(token, token, 60 * 60 * 24L);
        return ResultBody.success(token);
    }


    /**
     * 测试接口幂等
     *
     * @return
     */
    @GetMapping(value = "header")
    @NoRepeatSubmit(type = GlobalConstants.API_HEADER)
    public ResultBody<String> addOrder() {
        //业务逻辑 .....
        String token = ApiTokenUtils.getToken();
        redisUtils.set(token, token, 60 * 60 * 24L);
        return ResultBody.success(token);
    }

}
