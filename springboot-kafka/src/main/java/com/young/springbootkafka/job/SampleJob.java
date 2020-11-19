package com.young.springbootkafka.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * SampleJob
 *
 * @author yangbing
 * @date 2020/11/19 下午3:52
 */
@Slf4j
public class SampleJob extends QuartzJobBean {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        log.info("Quartz ---->  Hello, " + this.name);
    }
}
