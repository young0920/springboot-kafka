package com.young.springbootkafka;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author young
 */
@SpringBootApplication
@MapperScan("com.young.springbootkafka.mapper")
@Slf4j
@EnableCaching
@EnableSwagger2
@EnableAsync
//@EnableCasClient
//@EnableScheduling//定时任务
public class SpringbootKafkaApplication {

    public static void main(String[] args) {
        //设置rocketmq client 日志配置
        //System.setProperty(ClientLogger.CLIENT_LOG_USESLF4J,"true");
        SpringApplication.run(SpringbootKafkaApplication.class, args);
        log.info("程序正在运行");
    }

}
