package com.hemalatha.pandora.BaseTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PCtest {

	public static void main(String[] args) throws Exception {

		BlockingQueue queue = new ArrayBlockingQueue(1024);

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}
}

class Producer implements Runnable{

	protected BlockingQueue queue = null;

	public Producer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			System.out.println("Putting 1");
			queue.put("1");
			Thread.sleep(4000);
			System.out.println("Putting 2");
			queue.put("2");
			Thread.sleep(15000);
			System.out.println("Putting 3");
			queue.put("3");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable{

	protected BlockingQueue queue = null;

	public Consumer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			System.out.println("Taking");
			System.out.println("Took "+queue.take());
			System.out.println("Taking");
			System.out.println("Took "+queue.take());
			System.out.println("Taking");
			System.out.println("Took "+queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
