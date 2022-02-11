package com.assignment;
/*
 Class Name : Example2
 Methods:  Overrides the run method from Thread class
 Description: Example of multiple threads in single class by extending Thread class
 */
public class Example2 extends Thread{
	
	public static void main(String[] args) throws Exception {
		//Main thread started by JVM

		System.out.println("Example1 " + Thread.currentThread().getName() + " started");
		
		
		//Starting point of user defined thread creation t1
		Example2 t1= new Example2(); 		
		t1.setName("Thread 1");
		
		System.out.println("\nState of thread t1 is " + t1.getState());
		t1.start();  // thread t1 is started 
		
		Thread.sleep(3000); // Pause the execution of current thread for 3sec
		
		System.out.println("State of thread t1 is " + t1.getState());
		
		//Starting point of user defined thread creation t2		
		Example2 t2= new Example2();
		t2.setName("Thread 2"); 
		System.out.println("\nState of thread t2 is " + t2.getState());

		t2.start(); // thread t2 is started 
		System.out.println("State of thread t2 is " + t2.getState());

	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000); //Pause the execution of current thread for 2sec
			
		}catch(Exception e) {
			System.out.println("exception " + e.getMessage()); 
		}
		
		System.out.println("This is run method of " + Thread.currentThread().getName());
		System.out.println("The state is " + Thread.currentThread().getState());
	}

}
