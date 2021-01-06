package com.young.springbootkafka.controller;

import com.young.springbootkafka.constant.ResultBody;
import com.young.springbootkafka.service.IMinioService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * MinioController
 *
 * @author yangbing
 * @date 2021/1/5 下午3:20
 */
@RestController
@Slf4j
@RequestMapping(value = "minio")
@Api(tags = "minio")
public class MinioController {
    @Resource
    private IMinioService minioService;

    @GetMapping("presigned")
    public ResultBody<String> getPresignedUrl(){
        String presignedUrl = minioService.getPresignedUrl("2021-01-06/19fbc7535f3248e6818f0f5935a2dc8b.xlsx");
        return ResultBody.success(presignedUrl);
    }

}
