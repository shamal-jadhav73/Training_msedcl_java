package com.msedcl.main.repository;

import java.util.List;

import com.msedcl.main.entity.Employee;

public interface EmployeeRepository {
	//Add new Employee
	Employee addNewEmployee(Employee employee);
	//update Employee
	Employee updateEmployee(Employee employee);
	//delete employee by employee id
	boolean deleteEmployee(int employeeId);
	//select single employee
	Employee getEmployeeByEmployeeId(int employeeId);
	//list of all employees
	List<Employee> getAllEmployees();
	List<Employee> getAllEmployeeByName(String name);
	long getCountOfEmployees();
	List<Employee> getMaxSalariedEmployee();
	

}
