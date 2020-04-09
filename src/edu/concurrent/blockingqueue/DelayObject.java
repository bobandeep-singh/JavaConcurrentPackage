package edu.concurrent.blockingqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayObject implements Delayed{

	private String name;
	private long time;

	public DelayObject(String name, long time) {
		this.name = name;
		this.time = System.currentTimeMillis() + time;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff = this.time - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	@Override
	public int compareTo(Delayed obj) {
		if(this.time < ((DelayObject)obj).time) return -1;
		else if(this.time > ((DelayObject)obj).time) return 1;
		return 0;

	}

	@Override
	public String toString() {
		return "DelayObject [name=" + name + ", time=" + time + "]";
	}

}
/*
DelayQueue class implements the BlockingQueue interface.
DelayQueue is a specialized Priority Queue that orders elements based on their delay time.
It means that only those elements can be taken from the queue whose time has expired.

DelayQueue head contains the element that has expired in the least time.
If no delay has expired, then there is no head and poll will return null.
DelayQueue accepts only those elements that belong to a class of type Delayed.
DelayQueue implements the getDelay() method to return the remaining delay time.
 */