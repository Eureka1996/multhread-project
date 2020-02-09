package com.wufuqiang.multhread.base;

import org.junit.Test;

/**
 * @ author wufuqiang
 **/
public class BaseTest {

    @Test
    public void extendsThreadTest(){
        ExtendsThread thread1 = new ExtendsThread();
//        thread1.setName();
        ExtendsThread thread2 = new ExtendsThread();
        thread1.start();
        thread2.start();


    }

    public static void main(String[] args) {
        ExtendsThread thread1 = new ExtendsThread();
        ExtendsThread thread2 = new ExtendsThread();
        thread1.start();
        thread2.start();
        try {
            //主线程执行到这里会暂停，主线程等待thread2执行完毕后再开始执行
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ImplementsRunnable runnable1 = new ImplementsRunnable();
        //给子线程命名
        Thread thread3 = new Thread(runnable1,"runnable-thread1");
        //设置该线程为守护线程，和主线程一起被销毁
        thread3.setDaemon(true);
        thread3.start();
    }
}
