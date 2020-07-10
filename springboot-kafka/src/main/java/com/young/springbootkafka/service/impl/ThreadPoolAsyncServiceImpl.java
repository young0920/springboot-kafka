package com.young.springbootkafka.service.impl;

import com.young.springbootkafka.service.ThreadPoolAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程池一步请求实现
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/10 11:23
 */
@Service
@Slf4j
public class ThreadPoolAsyncServiceImpl implements ThreadPoolAsyncService {

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    private static int count;

    @Override
    @Async("asyncServiceExecutor")
    public Future<Boolean> executeAsync() {
        log.info("start executeAsync");

        while (true) {
            lock.lock();
            try {
                if (count > 100) {
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + "-->" + count);
                    count++;
                    condition.await(1, TimeUnit.SECONDS);
                }
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        log.info("end executeAsync");
        return new AsyncResult<>(true);

    }
}
