package edu.concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class WorkingWithDelayQueue {

	public static void main(String[] args) {
		BlockingQueue<DelayObject> delayedQueue = new DelayQueue<DelayObject>();
		delayedQueue.add(new DelayObject("A", 1000));
		delayedQueue.add(new DelayObject("B", 2000));
		delayedQueue.add(new DelayObject("C", 3000));
		delayedQueue.add(new DelayObject("D", 4000));
		
		System.out.println(delayedQueue);
		
		System.out.println(delayedQueue);
	}

}


/*
DelayQueue class implements the BlockingQueue interface.
The DelayQueue blocks the elements internally until a certain delay has expired.
The elements must implement the interface java.util.concurrent.Delayed.

Here is how the interface looks:
public interface Delayed extends Comparable<Delayed< {
 public long getDelay(TimeUnit timeUnit);
}

The value returned by the getDelay() method should be the delay remaining
before this element can be released. If 0 or a negative value is returned,
the delay will be considered expired, and the element released at the next take() etc. call on the DelayQueue.

The TimeUnit instance passed to the getDelay() method is an Enum that
tells which time unit the delay should be returned in.
The TimeUnit enum can take these values:
DAYS
HOURS
MINUTES
SECONDS
MILLISECONDS
MICROSECONDS
NANOSECONDS

The Delayed interface also extends the java.lang.Comparable interface, as you can see,
which means that Delayed objects can be compared to each other.
This is probably used internally in the DelayQueue to order the elements in the queue,
so they are released ordered by their expiration time.
*/