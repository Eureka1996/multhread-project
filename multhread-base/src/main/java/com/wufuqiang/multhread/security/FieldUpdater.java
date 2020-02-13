package com.wufuqiang.multhread.security;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @ author wufuqiang
 **/
@Data
@Slf4j
public class FieldUpdater {
    private static AtomicIntegerFieldUpdater<FieldUpdater> updater =
            AtomicIntegerFieldUpdater.newUpdater(FieldUpdater.class,"count");

    //必须用volatile修饰，非static修饰
    private volatile int count = 100;

    public static void main(String[] args) {
        FieldUpdater obj = new FieldUpdater();
        if(updater.compareAndSet(obj,100,120)){
            log.info("update success 1,{}",obj.getCount());
        }
        if(updater.compareAndSet(obj,100,120)){
            log.info("update success 2,{}",obj.getCount());
        }else{
            log.info("update failed 2,{}",obj.getCount());
        }

    }

}
