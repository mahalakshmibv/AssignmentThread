package com.assignment;

/*
Class Name : ExampleRunnable
Methods:  Overrides the run method from runnable interface and implements it
Description: Example of user defined thread creation by implementing Runnable interface 
  
*/

public class ExampleRunnable implements Runnable {
	
	public static void main(String[] args) throws Exception {
		System.out.println("This is main method");
		
		Thread t1 = new Thread(new ExampleRunnable()); // Creating thread object by passing ExampleRunnable as a parameter
        t1.start();
	}

	@Override
	public void run() { 
		// TODO Auto-generated method stub
		
		System.out.println("This is run method");
		
	}
	
	

}
