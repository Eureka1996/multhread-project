package com.wufuqiang.multhread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ author wufuqiang
 **/
public class NewScheduledThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        for(int i = 0 ;i < 20;i++){
            final int tmp = i;
            if(i%2 == 0){
                service.schedule(new Runnable() {
                    public void run() {
                        System.out.println(Thread.currentThread().getName()+",i="+tmp);
                    }
                },5, TimeUnit.SECONDS);
            }else{
                service.schedule(new Runnable() {
                    public void run() {
                        System.out.println(Thread.currentThread().getName()+",else i="+tmp);
                    }
                },5, TimeUnit.SECONDS);
            }
        }
    }
}
