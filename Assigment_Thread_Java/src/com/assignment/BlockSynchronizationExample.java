package com.assignment;
/*
 * Class Name: BlockSynchronizationExample
 * Description: Creates and starts Synchronize two diff threads with common object as parameter 
 */
public class BlockSynchronizationExample {

	//main method
	public static void main(String args[]) {
		// Common object for t1 and t2
		 Testsmple obj = new Testsmple();
		//create thread th1
		 MyThrd1 th1 = new MyThrd1(obj);
		 th1.setName("Infosys 1");
		//create thread th2
		MyThrd2 th2 = new MyThrd2(obj);
		 th2.setName("Infosys 2");

		th1.start();
		th2.start();
	}
}


class MyThrd1 extends Thread{
	Testsmple t;
	// Parameterized constructor with common object as a parameter 
	MyThrd1(Testsmple t) {
		this.t = t;
	}
	
	public void run() {
		t.printTestsample(10);
	}
	
}

class MyThrd2 extends Thread{
	Testsmple t;
	// Parameterized constructor with common object as a parameter 
	MyThrd2(Testsmple t) {
		this.t = t;
	}
	
	public void run() {
		t.printTestsample(200);
	}
	
}

class Testsmple {
	void printTestsample(int n) {
		System.out.println("Inside printTestsmple method " + Thread.currentThread().getName());
		//start of synchronized block
		synchronized (this) {
			System.out.println("Curent thread in synchronized block is: " + Thread.currentThread().getName());
			for (int i = 1; i <= 4; i++) {
				System.out.println(n * i);
				//exception handling
				try {
					Thread.sleep(500);
				} catch (Exception exc) {
					System.out.println(exc);
				}
			}
		}//end of synchronized block
	} // end of printTestsmple method
}