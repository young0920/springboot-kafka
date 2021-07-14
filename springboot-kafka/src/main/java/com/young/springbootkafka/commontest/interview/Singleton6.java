package com.young.springbootkafka.commontest.interview;

/**
 * Singleton6
 * <p>
 * 静态内部类模式（适用于多线程）
 *
 * @Author young
 * @Date 2021/7/5
 */
public class Singleton6 {
    /**
     * 1、内部类被加载和初始化时，才创建INSTANCE实例对象
     * 2、静态内部类不会自动创建,随着外部类的加载初始化而初始化，他是要单独去加载和实例化的
     * 3、因为是在内部类加载和初始化时，创建的，因此线程安全
     */
    private Singleton6() {
    }

    public static class Inner {
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return Inner.INSTANCE;
    }
}
