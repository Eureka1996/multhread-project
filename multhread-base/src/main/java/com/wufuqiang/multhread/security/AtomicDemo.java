package com.wufuqiang.multhread.security;

/**
 * @ author wufuqiang
 **/
public class AtomicDemo {
    public static void main(String[] args) {
        AtomicDemoThread r1 = new AtomicDemoThread();
        for(int i = 0 ; i < 10 ;i++){
            new Thread(r1).start();
        }
    }
}
