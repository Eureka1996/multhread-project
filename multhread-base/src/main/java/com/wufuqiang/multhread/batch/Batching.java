package com.wufuqiang.multhread.batch;

import com.wufuqiang.multhread.entries.BatchEntry;
import com.wufuqiang.multhread.entries.BatchIndex;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author wufuqiang
 **/
public class Batching {

    /**
     *
     * @param data 要分批的数据
     * @param num 每批的数量
     * @return
     */
    public static List<BatchIndex> batchingList(List<BatchEntry> data,int num){
        List<BatchIndex> batchIndex = new ArrayList<BatchIndex>();
        int startIndex = 0;
        while(startIndex < data.size()){
            int endIndex = startIndex + num -1;
            batchIndex.add(new BatchIndex(startIndex,endIndex<data.size()?endIndex:data.size()-1));
            startIndex = endIndex+1;
        }
        return batchIndex;
    }

}
