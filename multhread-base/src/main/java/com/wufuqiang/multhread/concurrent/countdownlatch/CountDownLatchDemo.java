package com.wufuqiang.multhread.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @ author wufuqiang
 **/
public class CountDownLatchDemo {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Runnable() {
            public void run() {
                System.out.println("子线程开始执行任务");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println("子线程任务执行完毕");
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                System.out.println("子线程开始执行任务");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println("子线程任务执行完毕");
            }
        }).start();
        try {
            //不为0的时候会一直等待
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕");
    }

}
