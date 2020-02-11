package com.wufuqiang.multhread.proconmodel.mylock;

import com.wufuqiang.multhread.entries.BatchEntry;

/**
 * @ author wufuqiang
 **/
public class ProConModel {
    public static void main(String[] args) {
        BatchEntry  entry = new BatchEntry();
        Producer p1 = new Producer(entry);
        Consumer c1 = new Consumer(entry);
        new Thread(p1).start();
        new Thread(c1).start();
    }
}
