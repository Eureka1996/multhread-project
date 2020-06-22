package com.wufuqiang.multhread.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//三个线程，循环打印
public class CyclePrint {

	public static void main(String[] args) {
		ShareResource shareResource = new ShareResource();
		new Thread(()->{
			while(true){
				shareResource.print5();
			}
		}).start();
		new Thread(()->{
			while (true) {
				shareResource.print10();
			}
		}).start();

		new Thread(()->{
			while (true) {
				shareResource.print15();
			}
		}).start();
	}
}

class ShareResource{
	private int number = 1;
	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();

	public void print5(){
		lock.lock();
		try{
			//判断
			while(number != 1){
				c1.await();
			}
			//干活
			for(int i = 0;i<5;i++){
				System.out.println(String.format("%s\t%d",Thread.currentThread().getName(),i));
			}
			number = 2;
			c2.signal();

		}catch (Exception e){

		}finally {
			lock.unlock();
		}
	}

	public void print10(){
		lock.lock();
		try{
			//判断
			while(number != 2){
				c2.await();
			}
			//干活
			for(int i = 0;i<10;i++){
				System.out.println(String.format("%s\t%d",Thread.currentThread().getName(),i));
			}
			number = 3;
			c3.signal();

		}catch (Exception e){

		}finally {
			lock.unlock();
		}
	}

	public void print15(){
		lock.lock();
		try{
			//判断
			while(number != 3){
				c3.await();
			}
			//干活
			for(int i = 0;i<15;i++){
				System.out.println(String.format("%s\t%d",Thread.currentThread().getName(),i));
			}
			number = 1;
			c1.signal();

		}catch (Exception e){

		}finally {
			lock.unlock();
		}
	}

}