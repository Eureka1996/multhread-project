package com.wufuqiang.multhread.threadpool;

/**
 * @ author wufuqiang
 **/
public class ExecutorsThread implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在执行");
    }
}
