package com.young.springbootkafka.config;

import com.young.springbootkafka.constant.GlobalConstants;
import com.young.springbootkafka.thread.threadpool.VisiableThreadPoolTaskExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * 线程池配置
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/10 11:06
 */
@Configuration
@Slf4j
public class ExecutorPoolConfig {


    /**
     * 线程池配置 executor
     * @return
     */
    @Bean
    public Executor asyncServiceExecutor() {
        log.info("start asyncServiceExecutor：线程池配置初始化");

        //ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();

        //配置核心线程数
        executor.setCorePoolSize(GlobalConstants.CORE_POOL_SIZE);

        //配置最大线程数
        executor.setMaxPoolSize(GlobalConstants.MAX_POOL_SIZE);

        //配置队列大小
        executor.setQueueCapacity(GlobalConstants.QUEUE_CAPACITY);

        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(GlobalConstants.THREAD_NAME_PREFIX);

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        //执行初始化
        executor.initialize();
        return executor;
    }
}
