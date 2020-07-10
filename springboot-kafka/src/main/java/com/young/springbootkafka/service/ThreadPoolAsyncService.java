package com.young.springbootkafka.service;

import java.util.concurrent.Future;

/**
 * 线程池异步请求
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/10 11:23
 */
public interface ThreadPoolAsyncService {
    /**
     * 执行异步任务
     */
    Future<Boolean> executeAsync();
}
