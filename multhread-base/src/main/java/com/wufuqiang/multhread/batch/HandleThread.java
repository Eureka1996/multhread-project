package com.wufuqiang.multhread.batch;

import com.wufuqiang.multhread.entries.BatchEntry;
import com.wufuqiang.multhread.entries.BatchIndex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ author wufuqiang
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HandleThread implements Runnable {
    private List<BatchEntry> data;
    private BatchIndex batchIndex;

    public void run() {
        for(int i = batchIndex.getStart();i<= batchIndex.getEnd();i++){
            System.out.println(String.format("%s----%s",Thread.currentThread().getName(),
                    data.get(i)));
        }
    }
}
