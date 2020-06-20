package com.wufuqiang.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {
	public static void main(String[] args) {
		testSynchronousQueue();
	}


	public static void testSynchronousQueue(){
		BlockingQueue<String> queue = new SynchronousQueue<>();

		new Thread(()->{

			try {
				System.out.println(String.format("%s\t put 1",Thread.currentThread().getName()));
				queue.put("1");
				System.out.println(String.format("%s\t put 2",Thread.currentThread().getName()));
				queue.put("2");
				System.out.println(String.format("%s\t put 3",Thread.currentThread().getName()));
				queue.put("3");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}).start();
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(5);
				System.out.println(String.format("%s get 1",queue.take()));
				TimeUnit.SECONDS.sleep(5);
				System.out.println(String.format("%s get 2",queue.take()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


		}).start();
	}
}
