package com.wufuqiang.multhread.proconmodel.mylock;

import com.wufuqiang.multhread.entries.BatchEntry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Condition;

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
            try{
                Thread.sleep(1000);
                entry.getLock().lock();
                if(!entry.isFlag()){
                    entry.getCondition().await();
                }
                System.out.println(entry);
                entry.setFlag(false);
                entry.getCondition().signal();
            }catch(Exception e){

            }finally{
                entry.getLock().unlock();
            }
        }
    }
}
