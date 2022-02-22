package com.assignment;
/*
 * Class Name: ExcecuterServiceExample
 * Description: Change given employees first name and last name to lowercase by using ExcecuterService with pool of 5 threads 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcecuterServiceExample {
	public static void main(String args[]) {

		int numberOfThreads = 5;	
		List<Employee> employeeList = new ArrayList<Employee>();
		
		employeeList.add(new Employee(1, "John", "smith"));
		employeeList.add(new Employee(2, "Alex", "petter"));
		employeeList.add(new Employee(3, "Mike", "Henry"));
		employeeList.add(new Employee(4, "Kris", "Gres"));
		employeeList.add(new Employee(5, "Abhi", "smith"));
		employeeList.add(new Employee(6, "Brenda", "James"));
		employeeList.add(new Employee(7, "Perry", "James"));
		employeeList.add(new Employee(8, "Monika", "Henry"));
		employeeList.add(new Employee(9, "Rachel", "Green"));
		employeeList.add(new Employee(10, "James", "bond"));
		

		ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);// Creation of ExecutorService with pool of 5 threads

		for (Employee emp : employeeList) {
			service.execute(() -> { // Executing 5 threads 
				emp.setfName(emp.getfName().toLowerCase()); //ExecutorService thread is doing the task 
				emp.setlName(emp.getlName().toLowerCase()); //ExecutorService thread is doing the task 
				System.out.println( emp.getfName() + " "+emp.getlName());
				System.out.println("This is a task assigned " + Thread.currentThread().getName());
			
				try {
					Thread.sleep(1000);
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			});
		}
		service.shutdown(); // Shutdown the service. 
		
		/*The below statement will throw error because we are trying to assign a task for 
		 * already shut downed ExecutorService
		 * service.execute(() -> {
		 *		 System.out.println("After shutdown assigning new task");
		 * });
		 * 
		 */
	}

}


