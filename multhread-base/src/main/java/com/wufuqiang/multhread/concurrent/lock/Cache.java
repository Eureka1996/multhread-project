package com.wufuqiang.multhread.concurrent.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ author wufuqiang
 **/
public class Cache {
    static private volatile Map<String,Object> map = new HashMap<String, Object>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();

    static public void put(String key,Object value){
        try{
            w.lock();
            System.out.println("写入数据中：key="+key+",value="+value);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key,value);
            System.out.println("写入数据结束");
            System.out.println();
        }catch(Exception e){

        }finally {
            w.unlock();
        }
    }

    static public Object get(String key){
        Object value = null;
        try{
            r.lock();
            System.out.println("正在读取数据：key="+key);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            value = map.get(key);
            System.out.println("读取数据结束：key="+key+",value="+value);
            System.out.println();
            return value;
        }catch(Exception e){

        }finally{
            r.unlock();
        }
        return value;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                for(int i = 0 ;i < 20;i++){
                    Cache.put(i+"",i+"");
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                for(int i = 0 ; i < 20;i++){
                    Cache.get(i+"");
                }
            }
        }).start();
    }
}
