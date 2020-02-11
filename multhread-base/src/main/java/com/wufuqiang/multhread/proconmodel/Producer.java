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
public class Producer implements Runnable {
    private volatile BatchEntry entry = new BatchEntry();

    public void run() {
        int count = 0;
        while(true){
            synchronized (entry){
                if(entry.isFlag()){
                    try {
                        //释放锁资源，等待被唤醒
                        entry.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(count == 0){
                    entry.setName("wufuqiang");
                    entry.setAge(18);
                }else{
                    entry.setName("maoyujiao");
                    entry.setAge(16);
                }
                count = (count+1)%2;
                entry.setFlag(true);
                entry.notify();
            }

        }

    }
}
