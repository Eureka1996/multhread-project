package com.wufuqiang.multhread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ author wufuqiang
 **/
public class NewFixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for(int i = 0 ;i < 20;i++){
            final int tmp = i;
            if(i%2 == 0){
                service.execute(new Runnable() {
                    public void run() {
                        System.out.println(Thread.currentThread().getName()+",i="+tmp);
                    }
                });
            }else{
                service.execute(new Runnable() {
                    public void run() {
                        System.out.println(Thread.currentThread().getName()+",else i="+tmp);
                    }
                });
            }
        }
    }
}
