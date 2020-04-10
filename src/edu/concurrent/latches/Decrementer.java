package edu.concurrent.latches;

import java.util.concurrent.CountDownLatch;

public class Decrementer implements Runnable{
	private CountDownLatch latch = null;
	
	

	public Decrementer(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		
		try {
			System.out.println("In Decrementer's run method");
			System.out.println("Latch count is: "+latch.getCount());
			
			Thread.sleep(1000);
			latch.countDown();
			System.out.println("Latch counted down to: "+latch.getCount());
			
			Thread.sleep(1000);
			latch.countDown();
			System.out.println("Latch counted down to: "+latch.getCount());
			
			Thread.sleep(1000);
			latch.countDown();
			System.out.println("Latch counted down to: "+latch.getCount());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
