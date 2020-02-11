package com.wufuqiang.multhread.security;

/**
 * @ author wufuqiang
 **/
public class VolatileDemo {
    public static void main(String[] args) {
        VolatileDemoThread t1 = new VolatileDemoThread();
        t1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.setFlag(false);
        System.out.println("flag已经修改为false");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.isFlag());
    }
}
