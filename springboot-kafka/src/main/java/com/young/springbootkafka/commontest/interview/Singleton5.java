package com.young.springbootkafka.commontest.interview;

/**
 * Singleton5
 * <p>
 * 线程安全（使用于多线程）
 *
 * @Author young
 * @Date 2021/7/5
 */
public class Singleton5 {
    /**
     * 1、构造器私有化
     * 2、用一个静态变量保存这个唯一的实例
     * 3、提供一个静态方法，获取这个实例对象
     */
    static Singleton5 instance;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5();
                }
                return instance;
            }
        }
        return instance;
    }
}
