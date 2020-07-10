package com.young.springbootkafka.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现Runnable接口
 * 优点：
 * 扩展性好，可以在此基础上继承其他类，实现其他必需的功能
 * 对于多线程共享资源的场景，具有天然的支持，适用于多线程处理一份资源的场景
 * 缺点：构造线程实例的过程相对繁琐一点
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/10 10:29
 */
public class MyRunnable implements Runnable {

    private int no;

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    private static int count;

    public MyRunnable(int no) {
        this.no = no;
    }


    /**
     * ReentrantLock实现
     */
    @Override
    public void run() {

        while (true) {
            lock.lock();
            try {
                if (count > 100) {
                    break;
                } else {
                    if (count % 3 == this.no) {
                        System.out.println(this.no + "-->" + count);
                        count++;
                    } else {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
/*        //线程的执行目标对象
        MyRunnable myRunnable = new MyRunnable();
        //实际的线程对象
        Thread thread = new Thread(myRunnable);
        //启动线程
        thread.start();*/
        Thread t1 = new Thread(new MyRunnable(0));
        Thread t2 = new Thread(new MyRunnable(1));
        Thread t3 = new Thread(new MyRunnable(2));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
