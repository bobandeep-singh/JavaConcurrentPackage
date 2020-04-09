package edu.concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	BlockingQueue<String> queue = null;
	
	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
		System.out.println("Consumer initialized");
	}
	@Override
	public void run() {
		System.out.println("In Consumer's run method");
		try {
			Thread.sleep(4000);
			System.out.println("Consuming start");
			System.out.println("Consuming: "+queue.take());
			System.out.println("Consuming: "+queue.take());
			System.out.println("Consuming: "+queue.take());
			System.out.println("Consuming finished");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
