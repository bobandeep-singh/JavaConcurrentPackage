package edu.concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/*
The PriorityBlockingQueue class implements the BlockingQueue interface.

The PriorityBlockingQueue is an unbounded concurrent queue.
It uses the same ordering rules as the java.util.PriorityQueue class.
You cannot insert null into this queue.

All elements inserted into the PriorityBlockingQueue must implement the java.lang.Comparable interface.
The elements thus order themselves according to whatever priority you decide in your Comparable implementation.

Notice that the PriorityBlockingQueue does not enforce any specific behaviour
for elements that have equal priority (compare() == 0).

Also notice, that in case you obtain an Iterator from a PriorityBlockingQueue,
the Iterator does not guarantee to iterate the elements in priority order.
 */

public class WorkingWithPriorityBlockingQueue {
	public static void main(String[] args) {
		Employee emp1 = new Employee("A", 1, "AB");
		Employee emp2 = new Employee("B", 2, "BC");
		Employee emp3 = new Employee("C", 4, "CD");
		Employee emp4 = new Employee("D", 3, "EF");
		Employee emp5 = new Employee("E", 7, "GH");
		Employee emp6 = new Employee("F", 4, "PQ");
		Employee emp7 = new Employee("G", 5, "QW");
		Employee emp8 = new Employee("H", 10, "DF");
		Employee emp9 = new Employee("I", 0, "HJ");

		BlockingQueue<Employee> queue =  new PriorityBlockingQueue<Employee>();
		queue.add(emp1); queue.add(emp2); queue.add(emp3); queue.add(emp4); queue.add(emp5);
		queue.add(emp6); queue.add(emp7); queue.add(emp8);  queue.add(emp9);
		
		for(Employee emp: queue) {
			System.out.println(emp);
		}
		
		//We can create the producer consumer also with some modified Producer Consumer classes.
		//But this example is enough to get the idea of how PriorityBlockingQueue works. 
	}
}
