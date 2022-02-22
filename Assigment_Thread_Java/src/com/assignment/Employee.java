
package com.assignment;

public class Employee {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	int id;
	String fName;
	String lName;
	
	public Employee(int id, String fName, String lName) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.fName = fName;
		this.lName = lName;
	}

}
