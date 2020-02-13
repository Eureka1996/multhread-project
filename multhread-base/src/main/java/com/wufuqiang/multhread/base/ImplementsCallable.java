package com.wufuqiang.multhread.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @ author wufuqiang
 **/
public class ImplementsCallable implements Callable<Integer>{
    public Integer call() throws Exception {
        System.out.println("正在做一些具体的操作");
        Thread.sleep(2000);
        System.out.println("操作完成");
        return 100;
    }

    public static void main(String[] args) {
        ImplementsCallable callable = new ImplementsCallable();
        FutureTask<Integer> tasks = new FutureTask<Integer>(callable);
        Thread t1 = new Thread(tasks);
        t1.start();
        System.out.println("主线程");
        try {
            Integer integer = tasks.get();
            System.out.println("线程执行的结果："+integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
