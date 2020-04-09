package edu.concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	
	protected BlockingQueue<String> queue = null;
	
	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
		System.out.println("Producer initialized");
	}

	@Override
	public void run() {
		System.out.println("In Producer's run method");
		try {
			System.out.println("Producing start");
			queue.put("1");
			Thread.sleep(1000);
			queue.put("2");
			Thread.sleep(1000);
			queue.put("3");
			Thread.sleep(1000);
			System.out.println("Producing finished");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
