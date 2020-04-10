package edu.concurrent.latches;

import java.util.concurrent.CountDownLatch;

public class Waiter implements Runnable{
	private CountDownLatch latch = null;
	
	public Waiter(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			System.out.println("We are in Waiter's run method and will call await on the latch");
			latch.await();
			Thread.sleep(1000);
			System.out.println("Waiter is released and it will resume its work now");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
