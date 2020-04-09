package edu.concurrent.blockingqueue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * The SynchronousQueue only has two supported operations: take() and put(), and both of them are blocking.
 */
public class WorkingWithSynchronousQueue {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executor = Executors.newFixedThreadPool(2);
		AtomicInteger sharedState = new AtomicInteger();
		CountDownLatch countDownLatch = new CountDownLatch(1);

		Runnable producer = () -> {
			Integer producedElement = ThreadLocalRandom
					.current()
					.nextInt();
			sharedState.set(producedElement);
			System.out.println("Produced: "+producedElement);
			countDownLatch.countDown();
		};

		Runnable consumer = () -> {
			try {
				countDownLatch.await();
				Integer consumedElement = sharedState.get();
				System.out.println("Consumed: "+consumedElement);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		};

		executor.execute(producer);
		executor.execute(consumer);

		executor.awaitTermination(500, TimeUnit.MILLISECONDS);
		executor.shutdown();

		System.out.println(countDownLatch.getCount());

		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Implementing the above logic with SynchronousQueue");

		ExecutorService executor2 = Executors.newFixedThreadPool(2);
		SynchronousQueue<Integer> queue = new SynchronousQueue<>();

		Runnable producer2 = () -> {
			Integer producedElement = ThreadLocalRandom
					.current()
					.nextInt();
			System.out.println("Produced: "+producedElement);
			try {
				queue.put(producedElement);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		};

		Runnable consumer2 = () -> {
			try {
				Integer consumedElement = queue.take();
				System.out.println("Consumed: "+consumedElement);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		};
		executor2.execute(producer2);
		executor2.execute(consumer2);

		executor2.awaitTermination(500, TimeUnit.MILLISECONDS);
		executor2.shutdown();
	}

}
/*
The SynchronousQueue class implements the BlockingQueue interface. 

The SynchronousQueue is a queue that can only contain a single element internally.
A thread inseting an element into the queue is blocked until another thread takes that element from the queue.
Likewise, if a thread tries to take an element and no element is currently present, that thread is blocked until
a thread insert an element into the queue.

Calling this class a queue is a bit of an overstatement. It's more of a rendezvous point.
 */