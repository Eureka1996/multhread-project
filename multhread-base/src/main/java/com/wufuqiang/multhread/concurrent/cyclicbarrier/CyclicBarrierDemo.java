package com.wufuqiang.multhread.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @ author wufuqiang
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{System.out.println("所有数据操作完成");});
        WriterThread r = new WriterThread(cyclicBarrier);
        for(int i = 0 ;i < 5;i++){
            new Thread(r).start();
        }
    }
}
