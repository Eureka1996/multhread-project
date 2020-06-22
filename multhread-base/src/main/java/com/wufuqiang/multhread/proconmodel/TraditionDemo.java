package com.wufuqiang.multhread.proconmodel;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TraditionDemo {
	public static void main(String[] args) {
		ShareData shareData = new ShareData();

		new Thread(() -> {
			for(int i = 0;i<5;i++){
				try {
					shareData.decrement();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(()->{
			for(int i = 0; i< 5;i++){
				try {
					shareData.increment();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();


	}
}

//资源类
class ShareData{
	private int number = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void increment() throws Exception{
		lock.lock();
		try {
			while(number != 0){
				condition.await();
			}
			number+=1;
			System.out.println(String.format("%s\t%d",Thread.currentThread().getName(),number));
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void decrement() throws Exception{
		lock.lock();
		try {
			while(number == 0){
				condition.await();
			}
			number-=1;
			System.out.println(String.format("%s\t%d",Thread.currentThread().getName(),number));
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
