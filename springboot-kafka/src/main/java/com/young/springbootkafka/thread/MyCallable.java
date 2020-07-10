package com.young.springbootkafka.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口
 *优点：
 * 扩展性好
 * 支持多线程处理同一份资源
 * 具备返回值以及可以抛出受检查异常
 * 缺点：
 * 相较于实现Runnable接口的方式，较为繁琐
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/10 10:32
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() {
        return "Hello, I am the defined thread created by implements Callable";
    }
    public static void main(String[] args){
        //线程执行目标
        MyCallable myCallable = new MyCallable();
        //包装线程执行目标，因为Thread的构造函数只能接受Runnable接口的实现类，而FutureTask类实现了Runnable接口
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        //传入线程执行目标，实例化线程对象
        Thread thread = new Thread(futureTask);
        //启动线程
        thread.start();
        String result = null;
        try {
            //获取线程执行结果
            result = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
