package com.jlife.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by chenjianan on 2017/1/17-16:36.
 * <p>
 * Describe: 同步屏幕
 * 若有多条线程，他们到达屏障时将会被阻塞，
 * 只有当所有线程都到达屏障时才能打开屏障，所有线程同时执行，
 * 若有这样的需求可以使用同步屏障。此外，当屏障打开的同时还能指定执行的任务。
 *
 * 闭锁 与 同步屏障 的区别
 * 闭锁只会阻塞一条线程，目的是为了让该条任务线程满足条件后执行；
 * 而同步屏障会阻塞所有线程，目的是为了让所有线程同时执行（实际上并不会同时执行，而是尽量把线程启动的时间间隔降为最少）。
 */
public class CyclicBarrierTest {

    public void  test(){

        final CyclicBarrier cyclicBarrier=new CyclicBarrier(3, new Runnable() {

            public void run() {
                System.out.println("到达屏幕后执行的任务、。。");
            }
        });


        new Thread(new Runnable() {

            public void run() {
                try {
                    System.out.println("线程1执行。。。。await前");
                    // 等待，（每执行一次barrier.await，同步屏障数量-1，直到为0时，打开屏障）
                    cyclicBarrier.await();

                    System.out.println("线程1执行。。。。await后");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {

            public void run() {
                try {
                    System.out.println("线程2执行。。。。await前");
                    // 等待，（每执行一次barrier.await，同步屏障数量-1，直到为0时，打开屏障）
                    cyclicBarrier.await();

                    System.out.println("线程2执行。。。。await后");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {

            public void run() {
                try {
                    System.out.println("线程3执行。。。。await前");
                    // 等待，（每执行一次barrier.await，同步屏障数量-1，直到为0时，打开屏障）
                    cyclicBarrier.await();

                    System.out.println("线程3执行。。。。await后");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public static void main(String[] args){
        new CyclicBarrierTest().test();
    }


}
