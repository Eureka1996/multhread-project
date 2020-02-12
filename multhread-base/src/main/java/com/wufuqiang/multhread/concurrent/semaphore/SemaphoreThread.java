package com.wufuqiang.multhread.concurrent.semaphore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @ author wufuqiang
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SemaphoreThread implements Runnable {
    private Semaphore semaphore;
    public void run() {
        int availablePermits = semaphore.availablePermits();
        String threadName = Thread.currentThread().getName();
        if(availablePermits > 0){
            System.out.println(threadName + "获取资源");
        }else{
            System.out.println(threadName + "已经没有资源");
        }

        try {
            semaphore.acquire();
            System.out.println(threadName+"终于获取资源");
            Thread.sleep(new Random().nextInt(30000));
            System.out.println(threadName+"操作资源结束");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
