package com.young.springbootkafka.constant;

/**
 * 常量定义
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/10 15:10
 */
public final class GlobalConstants {

    private GlobalConstants() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 线程池核心线程数
     */
    public static final int CORE_POOL_SIZE = 5;
    /**
     * 线程池最大线程数
     */
    public static final int MAX_POOL_SIZE = 5;
    /**
     * 线程池队列大小
     */
    public static final int QUEUE_CAPACITY = 500;
    /**
     * 线程池中的线程的名称前缀
     */
    public static final String THREAD_NAME_PREFIX = "async-service-";
    /**
     * 接口header
     */
    public static final String API_HEADER = "header";
}
