package com.young.springbootkafka.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ScheduledJob2
 *
 * @author yangbing
 * @date 2020/11/19 下午4:03
 */
public class ScheduledJob2 implements Job {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("CRON ----> schedule job2 is running ... + " + name + "  ---->  " + dateFormat.format(new Date()));
    }
}
