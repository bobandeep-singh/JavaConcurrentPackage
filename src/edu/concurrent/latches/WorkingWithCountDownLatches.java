package edu.concurrent.latches;

import java.util.concurrent.CountDownLatch;

/*
A java.util.concurrent.CountDownLatch is a concurrency construct that allows one or
more threads to wait for a given set of operations to complete.

A CountDownLatch is initialized with a given count. This count is decremented by calls 
to the countDown() method. Threads waiting for this count to reach zero can call one of the 
await() methods. Calling await() blocks the thread until the count reaches zero.

Below is a simple example. After the Decrementer has called countDown() 3 times on the CountDownLatch, 
the waiting Waiter is released from the await() call.
 */

public class WorkingWithCountDownLatches {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		
		Waiter waiter = new Waiter(latch);
		Decrementer decrementer = new Decrementer(latch);
		
		Thread threadOne = new Thread(waiter);
		Thread threadTwo = new Thread(decrementer);
		
		threadOne.start();
		threadTwo.start();

	}

}
