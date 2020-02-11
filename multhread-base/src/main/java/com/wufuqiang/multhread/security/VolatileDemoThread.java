package com.wufuqiang.multhread.security;

import lombok.Data;

/**
 * @ author wufuqiang
 **/
@Data
public class VolatileDemoThread extends Thread {
    private volatile boolean flag = true;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-子线程开始执行");
        while (flag){

        }
        System.out.println(Thread.currentThread().getName()+"-子线程执行结束");
    }
}
