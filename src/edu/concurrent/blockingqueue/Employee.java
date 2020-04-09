package edu.concurrent.blockingqueue;

public class Employee implements Comparable<Employee>{
	
	private String name;
	private int id;
	private String dept;
	
	public Employee(String name, int id, String dept) {
		super();
		this.name = name;
		this.id = id;
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", dept=" + dept + "]";
	}
	@Override
	public int compareTo(Employee o) {
		if(this.id < o.id) return 1;
		else if(this.id > o.id) return -1;
		else return 0;
	}
	
	

}
