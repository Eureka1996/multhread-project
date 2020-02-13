package com.wufuqiang.multhread.base;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @ author wufuqiang
 **/
public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer task运行的任务");
            }
        },100,2000);
    }
}
