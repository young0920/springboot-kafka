package com.young.springbootkafka.commontest.interview;

/**
 * Singleton
 * 1.某个类只能有一个实例: 构造器私有化
 * 2.它必须自行创建这个实例: 含有一个类的静态变量来保存这个唯一的实例
 * 3.必须自行向整个系统提供这个实例: 对外获取该实例对象的方式
 * 1)直接暴露 2)用静态变量的get方法获取
 * <p>
 * 直接实例化饿汉式(简洁直观)
 *
 * @Author young\
 * @Date 2021/7/5
 */
public class Singleton1 {

    public static final Singleton1 INSTANCE = new Singleton1();

    /**
     * 1、构造器私有化
     * 2、自行创建，并且用静态变量保存
     * 3、向外提供实例
     * 4、强调这是一个单例，我们可以用final修改
     */
    private Singleton1() {

    }
}
