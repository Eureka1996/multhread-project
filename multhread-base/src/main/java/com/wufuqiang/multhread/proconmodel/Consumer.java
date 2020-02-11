package com.wufuqiang.multhread.proconmodel;

import com.wufuqiang.multhread.entries.BatchEntry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ author wufuqiang
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consumer implements Runnable {
    private volatile BatchEntry entry ;

    public void run() {
        while(true){
            synchronized (entry){
                if(!entry.isFlag()){
                    try {
                        //释放锁资源，等待被唤醒
                        entry.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(entry);
                entry.setFlag(false);
                entry.notify();
            }

        }
    }
}
