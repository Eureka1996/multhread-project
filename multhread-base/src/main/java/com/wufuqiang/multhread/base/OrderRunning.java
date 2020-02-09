package com.wufuqiang.multhread.base;

/**
 * @ author wufuqiang
 **/
public class OrderRunning {
    public static void orderRunning(){
        final Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0;i<30;i++){
                    System.out.println(String.format("%s-i:%d",Thread.currentThread().getName(),i));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"线程1");
        final Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i = 0;i<30;i++){
                    System.out.println(String.format("%s-i:%d",Thread.currentThread().getName(),i));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"线程2");
        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                try {
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i = 0;i<30;i++){
                    System.out.println(String.format("%s-i:%d",Thread.currentThread().getName(),i));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"线程3");
        thread1.start();
//        try {
//            thread1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        thread2.start();
//        try {
//            thread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        thread3.start();
//        try {
//            thread3.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        orderRunning();
    }

}
