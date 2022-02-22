package com.assignment;

/*
 * Class Name: WithMethodSynchronizationExample
 * Description: Creates and starts Synchronize two diff threads with common object as parameter 
 */

public class WithMethodSynchronizationExample {
	public static void main(String[] args) throws Exception {

		TableSync obj = new TableSync();// Common object for t1 and t2

		MySyncThread1 t1 = new MySyncThread1(obj);// First user defined thread creation with common obj
		t1.setName("Infosys 1");
		t1.start();

		MySyncThread2 t2 = new MySyncThread2(obj);// Second user defined thread creation with common obj
		t2.setName("Infosys 2");
		t2.start();

	}
}

class MySyncThread1 extends Thread {
	TableSync t;

	MySyncThread1(TableSync t) {// Parameterized constructor with common object as a parameter 
		this.t = t;
	}

	public void run() {
		t.printTable(5);
	}

}

class MySyncThread2 extends Thread {
	TableSync t;

	MySyncThread2(TableSync t) {// Parameterized constructor with common object as a parameter 
		this.t = t;
	}

	public void run() {
		t.printTable(10);
	}

}

//Common object with method Synchronization 
class TableSync {
	//starting point of synchronized method 
	synchronized public void printTable(int n) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i + " excecuted by " + Thread.currentThread().getName());
		}
		try {

			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	// end of synchronized method 
}