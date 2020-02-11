package com.wufuqiang.multhread.entries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ author wufuqiang
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BatchEntry {
    private String name;
    private int age;
    private boolean flag;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    public BatchEntry(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
