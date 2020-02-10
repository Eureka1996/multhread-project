package com.wufuqiang.multhread.batch;

import com.wufuqiang.multhread.entries.BatchEntry;
import com.wufuqiang.multhread.entries.BatchIndex;
import com.wufuqiang.multhread.mock.CreateLog;

import java.util.List;

/**
 * @ author wufuqiang
 **/
public class HandleByBatch {
    public static void main(String[] args) {
        List<BatchEntry> batchEntry = CreateLog.createBatchEntry(1111);
        List<BatchIndex> batchIndices = Batching.batchingList(batchEntry, 100);
        int batchCount = 0;
        for(BatchIndex batchIndex:batchIndices){
            new Thread(new HandleThread(batchEntry,batchIndex),"线程"+batchCount).start();
            batchCount+=1;
        }
    }
}
