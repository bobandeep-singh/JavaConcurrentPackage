package edu.concurrent.latches;

import java.util.concurrent.CountDownLatch;

public class WorkingWithCountDownLatchesV2 {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(4);
		
		Worker w1 = new Worker("Worker_Th_1", 2000, latch);
		Worker w2 = new Worker("Worker_Th_2", 2000, latch);
		Worker w3 = new Worker("Worker_Th_3", 2000, latch);
		Worker w4 = new Worker("Worker_Th_4", 2000, latch);

		w1.start();
		w2.start();
		w3.start();
		w4.start();
		System.out.println("We have started all the threads");
		System.out.println("Going to call await on the latch");
		
		latch.await();
		
		System.out.println("Await is finished");
	}

}


class Worker extends Thread{
	private int delay;
	private CountDownLatch latch;
	
	public Worker(String name, int delay, CountDownLatch latch) {
		super(name);
		this.delay = delay;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(delay);
			latch.countDown();
			System.out.println(Thread.currentThread().getName() + " is finished");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}