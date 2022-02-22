package com.assignment;
/*
Class Name : DeadLockExample
Description: Creates multiple threads t1 and t2 with same resource and held in deadlock   
*/
public class DeadLockExample {
	public static void main(String[] args) throws Exception {
		String s1 = "sample1";
		String s2 = "sample2";
		// create thread t1 
		Thr1 t1 = new Thr1(s1,s2);
		t1.setName("Infosys-1");
		t1.start();
		// create tread t2
		Thr2 t2 = new Thr2(s1,s2);
		t2.setName("Infosys-2");
		t2.start();
	}
}

class Thr1 extends Thread {
	String s1;
	String s2;
	// Parameterized constructor with common string objects as a parameter 
	Thr1(String s1, String s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	public void run() {
		synchronized (s1) {// 1st lock
			System.out.println("Accquired lock on s1");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			synchronized (s2) {// 2nd lock
				System.out.println("Accquired lock on s2");
			} // exit lock2
		} // exit lock1

	}
}

class Thr2 extends Thread {
	String s1;
	String s2;
	// Parameterized constructor with common string objects as a parameter 
	Thr2(String s1, String s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	public void run() {
		synchronized (s2) {// 2st lock
			System.out.println("Accquired lock on s2");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Thread 2 waiting for s1... ");
			synchronized (s1) {// 1nd lock
				System.out.println("Accquired lock on s1");
			} // exit 1st lock
		} // exit 2nd lock
	}
}