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
public class Producer implements Runnable {
    private volatile BatchEntry entry = new BatchEntry();

    public void run() {
        int count = 0;
        while(true){
            try{

                entry.getLock().lock();
                if(entry.isFlag()){
                    entry.getCondition().await();
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
                entry.getCondition().signal();
            }catch (Exception e){

            }finally{
                entry.getLock().unlock();
            }
        }
    }
}
