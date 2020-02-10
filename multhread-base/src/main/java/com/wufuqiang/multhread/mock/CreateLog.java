package com.wufuqiang.multhread.mock;

import com.wufuqiang.multhread.entries.BatchEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author wufuqiang
 **/
public class CreateLog {

    public static List<BatchEntry> createBatchEntry(int n){
        List<BatchEntry> result = new ArrayList<BatchEntry>();
        for(int i = 0 ; i < n ;i++){
            result.add(new BatchEntry("wufuqiang",i));
        }
        return result;
    }
}
