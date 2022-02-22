package com.assignment;

public class ThreadByLamba{
	public static void main(String[] args) throws Exception {
		//Thead creation using lamba
		Thread t1= new Thread(()-> {
			System.out.println("This is run method inside lamba of thread " + Thread.currentThread().getName());
		});
		
		t1.start();
		t1.setName("Infosys-1");
	}

}
