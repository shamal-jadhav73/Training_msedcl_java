package com.msedcl.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.domain.msedcl.main.Employee;

public class EmployeeRecordsMain {

	public static void main(String[] args) {
	 Employee employee1= new Employee(1, "Test 1", 10000.00);
	 Employee employee2= new Employee(2, "Test 2", 20000.00);
	 Employee employee3= new Employee(3, "Test 3", 40000.00);
	 System.out.println(employee1);
	 
	 List<Employee> employeeList=Arrays.asList(employee1,employee2,employee3);
	 employeeList.forEach(e->System.out.println(e));
	 
	 System.out.println("Trying records getter Methods and for loop for printing");
	 for(Employee e:employeeList)
	 {
		 System.out.println(e.employeeId());
		 System.out.println(e.name());
		 System.out.println(e.salary());
	 }

	}

}
