package com.wufuqiang.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
		queue.add("wu");
		queue.add("fu");
		queue.add("qiang");
//		queue.add("maoyujiao");

		System.out.println(queue.remove());
		queue.remove();
		queue.remove();
//		queue.remove();

		BlockingQueue<String> queue2 = new ArrayBlockingQueue<>(3);
		queue2.offer("a");
		queue2.offer("b");
		queue2.offer("c");
		try {
			queue2.offer("d",5L, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.out.println("Exception");
			e.printStackTrace();
		}

		System.out.println(queue2.poll());
		System.out.println(queue2.poll());
		System.out.println(queue2.poll());
		try {
			System.out.println(queue2.poll(4L,TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		BlockingQueue<String> queue3 = new ArrayBlockingQueue<>(3);
		try {
			queue3.put("a");
			queue3.put("a");
			queue3.put("a");
			queue3.put("a");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			queue3.take();
			queue3.take();
			queue3.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
