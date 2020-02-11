package com.wufuqiang.multhread.base;

/**
 * @ author wufuqiang
 **/
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ResNumber resNumber = new ResNumber();
        ThreadLocalThread r1 = new ThreadLocalThread(resNumber);
        new Thread(r1).start();
        new Thread(r1).start();
    }
}
