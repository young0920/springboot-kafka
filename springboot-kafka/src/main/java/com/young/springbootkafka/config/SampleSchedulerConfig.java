package com.young.springbootkafka.config;

import com.young.springbootkafka.job.SampleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;

/**
 * SampleScheduler  当且仅当需调度一次或者以固定时间间隔周期执行调度
 *
 * @author yangbing
 * @date 2020/11/19 下午3:53
 */
//@Configuration
public class SampleSchedulerConfig {
    @Bean
    public JobDetail sampleJobDetail() {
        // 链式编程,可以携带多个参数,在Job类中声明属性 + setter方法
        return JobBuilder.newJob(SampleJob.class).withIdentity("sampleJob")
                .usingJobData("name","World").storeDurably().build();
    }

    @Bean
    public Trigger sampleJobTrigger(){
        // 每隔两秒执行一次
        SimpleScheduleBuilder scheduleBuilder =
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();
        return TriggerBuilder.newTrigger().forJob(sampleJobDetail()).withIdentity("sampleTrigger")
                .withSchedule(scheduleBuilder).build();
    }
}
