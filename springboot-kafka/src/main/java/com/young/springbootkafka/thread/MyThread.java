package com.young.springbootkafka.thread;

/**
 * 集成thread类
 * <p>
 * 优点：实现简单，只需实例化继承类的实例，即可使用线程
 * 缺点：扩展性不足，Java是单继承的语言，如果一个类已经继承了其他类，就无法通过这种方式实现自定义线程
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/10 10:27
 */
public class MyThread extends Thread {
    /**
     * 线程体
     */
    @Override
    public void run() {
        System.out.println("Hello, I am the defined thread created by extends Thread");
    }

    public static void main(String[] args) {
        //实例化自定义线程类实例
        Thread thread = new MyThread();
        //调用start()实例方法启动线程
        thread.start();
    }
}
