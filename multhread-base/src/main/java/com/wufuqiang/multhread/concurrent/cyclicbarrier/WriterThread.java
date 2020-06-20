package com.wufuqiang.multhread.concurrent.cyclicbarrier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ author wufuqiang
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WriterThread implements Runnable {
    private CyclicBarrier cyclicBarrier;
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始做写操作");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"写操作完成");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
//        System.out.println("所有写操作都完成");
    }
}
