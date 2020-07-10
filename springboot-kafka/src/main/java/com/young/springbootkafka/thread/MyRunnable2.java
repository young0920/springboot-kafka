package com.young.springbootkafka.thread;

/**
 * synchronized实现3个线程打印0-100
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/10 10:50
 */
public class MyRunnable2 implements Runnable {
    private static Object lock = new Object();

    private static int count = 0;

    int no;

    public MyRunnable2(int no) {
        this.no = no;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (count > 100) {
                    break;
                }
                if (count % 3 == this.no) {
                    System.out.println(this.no + "--->" + count);
                    count++;
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notifyAll();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
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
