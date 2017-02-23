package com.jlife.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by chenjianan on 2017/1/17-15:11.
 * <p>
 * Describe: CountDownLatch 闭锁练习，
 * 使用场景：若有多条线程，其中一条线程要等其他线程执行完才能执行，那么可以用闭锁；
 * 闭锁只会阻塞一条线程，目的是为了让该条任务线程满足条件后执行；
 */
public class CountDownLatchTest {

    CountDownLatch latch=new CountDownLatch(2);//初始化闭锁，并设置资源数目
    public void test(){




        new Thread(new Runnable() {

            public void run() {
                try {
                    // 本线程必须等待所有资源加载完后才能执行
                    latch.await();
                    // 当闭锁数量为0时，await返回，执行接下来的任务
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程3执行。。。。");
            }
        }).start();



        new Thread(new Runnable() {

            public void run() {
                System.out.println("线程2执行。。。。");
                System.out.println("线程2执行。。。。"+latch.getCount());
                // 本资源加载完后，闭锁-1
                latch.countDown();
                System.out.println("线程2执行。。。。"+latch.getCount());
            }
        }).start();

        new Thread(new Runnable() {

            public void run() {
                System.out.println("线程1执行。。。。");
                System.out.println("线程1执行。。。。"+latch.getCount());
                // 本资源加载完后，闭锁-1
                latch.countDown();
                System.out.println("线程1执行。。。。"+latch.getCount());
            }
        }).start();

    }


    public static void main(String[] args){
        new CountDownLatchTest().test();
    }
}
