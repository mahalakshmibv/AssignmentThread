package com.assignment;

/*
Class Name : ExampleJoin
Description: Creates multiple threads t1 and t2 
*/

public class ExampleJoin {
	public static void main(String[] args) throws Exception{

		ThreadExmaple t1= new ThreadExmaple();
		t1.setName("Thread 1");
		ThreadExmaple t2= new ThreadExmaple();
		t2.setName("Thread 2");

	
		t1.start(); 
		
		t1.join();// thread t2 will be executed after the thread t1
		 
		t2.start();
	}

}

/*
Class Name : ThreadExmaple
Methods:  Overrides the run method from Thread class
Description: prints the name of current thread and counter number
*/

 class ThreadExmaple extends Thread{
		public void run() {
			for(int i=0; i< 2; i++) {
				try {
					Thread.sleep(300);
					System.out.println("The current thread name " +  Thread.currentThread().getName());
					System.out.println("The counter is "+ i);
				}catch(Exception e) {
				
			}
		}
			
	}
}
	

