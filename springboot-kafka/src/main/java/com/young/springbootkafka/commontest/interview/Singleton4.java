package com.young.springbootkafka.commontest.interview;

/**
 * Singleton4
 * <p>
 * 线程不安全（使用于单线程）
 *
 * @Author young
 * @Date 2021/7/5
 */
public class Singleton4 {
    /**
     * 1、构造器私有化
     * 2、用一个静态变量保存这个唯一的实例
     * 3、提供一个静态方法，获取这个实例对象
     */
    static Singleton4 instance;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;

    }
}
