package com.wufuqiang.multhread.security;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ author wufuqiang
 **/
@Data
@Slf4j
public class AtomicBooleanDemo {
    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行线程数
    public static int threadTotal =  200;
    public static AtomicBoolean isHappened = new AtomicBoolean(false);
    public static int count = 0;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for ( int i = 0 ; i < clientTotal;i++){
            service.execute(()->{
                try {
                    semaphore.acquire();
                    test();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
        log.info("isHappened:{}",isHappened.get());

    }

    private static void add(){
        count ++;
    }
    private static void test(){
        if(isHappened.compareAndSet(false,true)){
            log.info("execute");
        }
    }
}
