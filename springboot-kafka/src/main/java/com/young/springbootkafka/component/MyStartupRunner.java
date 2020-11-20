package com.young.springbootkafka.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

import javax.annotation.Resource;

/**
 * MyStartupRunner  方式1：项目启动时执行定时任务
 *
 * @author yangbing
 * @date 2020/11/19 下午4:06
 */
//@Component
@Slf4j
public class MyStartupRunner implements CommandLineRunner {

    @Resource
    public CronSchedulerJob scheduleJobs;

    @Override
    public void run(String... args) throws Exception {
        scheduleJobs.scheduleJobs();
        log.info(">>>>>>>>>>>>>>>定时任务开始执行<<<<<<<<<<<<<");
    }
}
