package com.assignment;
/*
 * Class Name: WithoutSynchronization
 * Description: Creates and starts two diff threads with common object as parameter 
 */
public class WithoutSynchronization {
	public static void main(String[] args) throws Exception{
		
		Table obj = new Table();// Common object for t1 and t2
		
		MyThread1 t1 = new MyThread1(obj); // First user defined thread creation with common obj
		t1.setName("Infosys 1");
		t1.start();

		MyThread2 t2 = new MyThread2(obj);// Second user defined thread creation with common obj
		t2.setName("Infosys 2");		
		t2.start();
	
	}
}
class MyThread1 extends Thread{
	Table t;
	
	MyThread1(Table t) {// Parameterized constructor with common object as a parameter 
		this.t = t;
	}
	
	public void run() {
		t.printTable(5);
	}
	
}

class MyThread2 extends Thread{
	Table t;
	
	MyThread2(Table t) {// Parameterized constructor with common object as a parameter 
		this.t = t;
	}
	
	public void run() {
		t.printTable(10);
	}
	
}

//for common object
class Table{
	 
	public void printTable(int n) {
		for(int i = 1; i<=5; i++){
			System.out.println(n* i + " excecuted by " + Thread.currentThread().getName());
		}
		try {
			
			Thread.sleep(1000);
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
}