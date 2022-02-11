package com.assignment;
/*
  Class Name : Example1 
  Methods: Overrides the run method from Thread class
  Description: Example of user defined thread creation by extending Thread class 
  
 */
public class Example1 extends Thread{

	public static void main(String[] args) {
		//Main thread started by JVM
		System.out.println("Example1  " + Thread.currentThread().getName() + " thread started"); 
		
		//Starting point of user defined thread creation
		Example1 t1 = new Example1(); // Created user defined thread
		t1.setName("Thread 1");  // set the Name for thread
		
		System.out.println("\nState of thread t1:  " + t1.getState());
		
		t1.start();             // method to start user defined thread 
		System.out.println("State of thread t1:  " + t1.getState());
		
	}

	@Override
	// User defined thread logic goes here 
	public void run() {
		
		System.out.println("This is run method of  " + Thread.currentThread().getName());
	}
}