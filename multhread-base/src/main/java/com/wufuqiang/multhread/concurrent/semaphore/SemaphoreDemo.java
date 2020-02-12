package com.wufuqiang.multhread.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @ author wufuqiang
 **/
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        SemaphoreThread r1 = new SemaphoreThread(semaphore);
        for(int i = 0 ;i < 20;i++){
            new Thread(r1).start();
        }

    }
}
