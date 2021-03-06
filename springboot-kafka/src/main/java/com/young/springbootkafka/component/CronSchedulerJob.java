package com.young.springbootkafka.component;

import com.young.springbootkafka.job.ScheduledJob;
import com.young.springbootkafka.job.ScheduledJob2;
import org.quartz.*;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * CronSchedulerJob  复杂定时任务
 *
 * @author yangbing
 * @date 2020/11/19 下午4:04
 */
@Component
public class CronSchedulerJob {

    @Resource
    private SchedulerFactoryBean schedulerFactoryBean;

    private void scheduleJob1(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob.class) .withIdentity("job1", "group1").build();
        // 6的倍数秒执行 也就是 6 12 18 24 30 36 42 ....
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/6 * * * * ?");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .usingJobData("name","王智1").withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }

    private void scheduleJob2(Scheduler scheduler) throws SchedulerException{
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob2.class) .withIdentity("job2", "group2").build();
        // 12秒的倍数执行  12  24 36  48  60
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/12 * * * * ?");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2")
                .usingJobData("name","王智2").withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }

    /**
     * @Author Smith
     * @Description 同时启动两个定时任务
     * @Date 16:31 2019/1/24
     * @Param
     * @return void
     **/
    public void scheduleJobs() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduleJob1(scheduler);
        scheduleJob2(scheduler);
    }
}
