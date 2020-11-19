package com.young.springbootkafka.component;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * SchedulerListener 定时执行定时任务脚本
 *
 * @author yangbing
 * @date 2020/11/19 下午4:09
 */
//@Configuration
//@EnableScheduling
//@Component
public class SchedulerListener {

    @Autowired
    public CronSchedulerJob scheduleJobs;

    @Scheduled(cron="0 47 16 24 1 ?")
    public void schedule() throws SchedulerException {
        scheduleJobs.scheduleJobs();
        System.out.println(">>>>>>>>>>>>>>>定时任务开始执行<<<<<<<<<<<<<");
    }

}
