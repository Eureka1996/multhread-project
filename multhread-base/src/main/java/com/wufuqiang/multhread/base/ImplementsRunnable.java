package com.wufuqiang.multhread.base;

/**
 * @ author wufuqiang
 **/
public class ImplementsRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 100 ; i++){
            //获取当前线程名称
            String threadName = Thread.currentThread().getName();
            System.out.println(String.format("%s-i:%d",threadName,i));
        }
    }
}
