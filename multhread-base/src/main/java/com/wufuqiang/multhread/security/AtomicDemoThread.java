package com.wufuqiang.multhread.security;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ author wufuqiang
 **/
public class AtomicDemoThread implements Runnable {
//    private int count = 0;
    private AtomicInteger count = new AtomicInteger(0);
    public void run() {
        for(int i = 0 ;i < 1000;i++){
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count.incrementAndGet();
        }
        System.out.println(Thread.currentThread().getName()+","+count);
    }
}
