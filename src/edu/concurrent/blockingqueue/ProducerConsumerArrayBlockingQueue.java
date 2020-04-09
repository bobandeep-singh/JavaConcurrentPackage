package edu.concurrent.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
The ArrayBlockingQueue class implements the BlockingQueue interface.

ArrayBlockingQueue is a bounded, blocking queue that stores the elements internally in an array.
That it is bounded means that it cannot store unlimited amounts of elements.
There is an upper bound on the number of elements it can store at the same time.
You set the upper bound at instantiation time, and after that it cannot be changed.

The ArrayBlockingQueue stores the elements internally in FIFO (First In, First Out) order.
The head of the queue is the element which has been in queue the longest time,
and the tail of the queue is the element which has been in the queue the shortest time.
 */

public class ProducerConsumerArrayBlockingQueue {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("ProducerConsumerArrayBlockingQueue(+)");

		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		Thread thread1 = new Thread(producer);
		Thread thread2 = new Thread(consumer);

		thread1.start();
		//thread1.join();

		thread2.start();

		Thread.sleep(4000);
		System.out.println("ProducerConsumerArrayBlockingQueue(-)");
	}

}
