package com.jlife.thread;

import java.util.concurrent.Semaphore;

/**
 * Created by chenjianan on 2017/1/17-17:06.
 * <p>
 * Describe: 信号量
 * 使用场景
 * 若有m个资源，但有n条线程（n>m），因此同一时刻只能允许m条线程访问资源，此时可以使用Semaphore控制访问该资源的线程数量。
 */
public class SemaphoreTest {
    public void  test() {
        // 创建信号量对象，并给予3个资源
        final Semaphore semaphore = new Semaphore(3);

        // 开启10条线程
        for (int i = 0; i < 10; i++)
            new Thread(new Runnable() {

                public void run() {
                    try {
                        // 获取资源，若此时资源被用光，则阻塞，直到有线程归还资源
                        semaphore.acquire();
                        System.out.println("执行任务" + Thread.currentThread().getName());
                        System.out.println("释放资源" + Thread.currentThread().getName());
                        // 释放资源
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

    }

    public static void main(String[] args){
        new SemaphoreTest().test();
    }
}
