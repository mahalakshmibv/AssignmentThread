package com.assignment;
/*
Class Name : DeadLockSolution
Description: provides solution for dead lock problem by waiting the resource to compete its execution
             before assigning it to another thread 
*/
public class DeadLockSolution {

	public static void main(String[] args) throws Exception {
		String s1 = "sample1";
		String s2 = "sample2";
		// create thread t1
		Thrd1 t1 = new Thrd1(s1, s2);
		t1.setName("Infosys-1");
		t1.start();
		// create tread t2
		Thrd2 t2 = new Thrd2(s1, s2);
		t2.setName("Infosys-2");
		t2.start();
	}
}

class Thrd1 extends Thread {
	String s1;
	String s2;

	// Parameterized constructor with common string objects as a parameter
	Thrd1(String s1, String s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	public void run() {
		synchronized (s2) {// 1st lock - locking s2 first in thread 1 to avoid dead lock
			System.out.println("Accquired lock on s2");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			synchronized (s1) {// 2nd lock
				System.out.println("Accquired lock on s1");
			} // exit lock2
		} // exit lock1

	}
}

class Thrd2 extends Thread {
	String s1;
	String s2;

	// Parameterized constructor with common string objects as a parameter
	Thrd2(String s1, String s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	public void run() {
		synchronized (s2) {// 2st lock
			System.out.println("Accquired lock on s2");

			// Thread-2 have s2 but need s1 also
			synchronized (s1) {// 1nd lock
				System.out.println("Accquired lock on s1");
			} // exit 1st lock
		} // exit 2nd lock
	}
}
