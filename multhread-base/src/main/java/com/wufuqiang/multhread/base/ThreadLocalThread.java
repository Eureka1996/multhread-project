package com.wufuqiang.multhread.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ author wufuqiang
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThreadLocalThread implements  Runnable {
    private ResNumber resNumber;
    public void run() {
        for(int i = 0 ;i< 5;i++){
            System.out.println(Thread.currentThread().getName()+",number="+resNumber.getNumber());
        }
    }
}


