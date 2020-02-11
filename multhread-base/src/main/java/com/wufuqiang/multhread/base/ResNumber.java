package com.wufuqiang.multhread.base;

/**
 * @ author wufuqiang
 **/
public class ResNumber {
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public Integer getNumber(){
        int count = threadLocal.get()+1;
        threadLocal.set(count);
        return count;
    }
}
