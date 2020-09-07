package com.young.springbootkafka.config;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * MinioConfig
 *
 * @Author yangbing
 * @Date 2020/9/7 9:23 上午
 */
@Configuration
@Slf4j
public class MinioConfig {
    @Value("${minio.url}")
    private String url;

    @Value("${minio.access-key}")
    private String accessKey;

    @Value("${minio.secret-key}")
    private String secretKey;


    @Bean
    public MinioClient minioClient() {
        log.info("minio初始化！");
        MinioClient minioClient = null;
        try {
            minioClient = new MinioClient(url, accessKey, secretKey);
        } catch (InvalidEndpointException | InvalidPortException e) {
            log.error("minio初始化失败！", e);
        }
        return minioClient;
    }
}