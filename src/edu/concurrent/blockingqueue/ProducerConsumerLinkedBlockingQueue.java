package edu.concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*
The LinkedBlockingQueue class implements the BlockingQueue interface.

The LinkedBlockingQueue keeps the elements internally in a linked structure (linked nodes).
This linked structure can optionally have an upper bound if desired.
If no upper bound is specified, Integer.MAX_VALUE is used as the upper bound.

The LinkedBlockingQueue stores the elements internally in FIFO (First In, First Out) order.
The head of the queue is the element which has been in queue the longest time, 
and the tail of the queue is the element which has been in the queue the shortest time.
 */

public class ProducerConsumerLinkedBlockingQueue {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("ProducerConsumerLinkedBlockingQueue(+)");

		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(1024);

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		Thread thread1 = new Thread(producer);
		Thread thread2 = new Thread(consumer);

		thread1.start();
		//thread1.join();

		thread2.start();

		Thread.sleep(4000);
		System.out.println("ProducerConsumerLinkedBlockingQueue(-)");
	}

}
