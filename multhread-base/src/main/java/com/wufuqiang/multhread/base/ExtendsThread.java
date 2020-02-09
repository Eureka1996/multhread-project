package com.wufuqiang.multhread.base;

/**
 * @ author wufuqiang
 **/
public class ExtendsThread extends Thread {
    @Override
    public void run() {
        for(int i = 0 ; i < 100 ;i++){
            System.out.println(String.format("%s-i:%d",currentThread().getName(),i));
        }
    }
}
