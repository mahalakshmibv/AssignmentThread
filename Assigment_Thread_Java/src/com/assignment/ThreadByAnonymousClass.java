package com.assignment;
/*
 * Class Name:ThreadByAnonymousClass
 * Description: 3 types of example to create a thread using anonymous class feature 
 */

public class ThreadByAnonymousClass {

	public static void main(String[] args) {
		
		//Example 1 - Thread creation using Anonymous class 
		new Thread() {
			@Override
			// User defined thread logic goes here 
			public void run() {				
				System.out.println("This is run Anonymous class run method");
			}	
		}.start(); // starting the thread by directly without any thread variable
		
		//Example 2 - Thread creation using Anonymous class 
		Thread t2 = new Thread() {
			@Override
			// User defined thread logic goes here 
			public void run() {				
				System.out.println("This is another run Anonymous class run method");
			}	
		};
		t2.start();
		
		//Example 3 - Thread creation using Anonymous class by using runnable

		Thread t3 = new Thread(new Runnable(){
			@Override
			// User defined thread logic goes here 
			public void run() {				
				System.out.println("This is Anonymous class run method using runnable");
			}	
		});
		
		t3.start();

	}

}
