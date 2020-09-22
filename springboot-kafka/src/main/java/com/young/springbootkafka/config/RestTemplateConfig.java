package com.young.springbootkafka.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplateConfig配置
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/13 14:16
 */
@Configuration
@Slf4j
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        log.info("restTemplate初始化！");
        // 创建一个 httpCilent 简单工厂
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        //设置连接超时   时间单位为ms
        factory.setConnectTimeout(15000);
        // 设置读取超时
        factory.setReadTimeout(5000);
        return factory;
    }

}
