package com.msedcl.main.client.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.dto.Department;
import com.msedcl.main.dto.Employee;
import com.msedcl.main.service.EmployeeServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("employeeapi")
public class EmployeeController {
	
	private final EmployeeServiceImpl employeeServiceImpl;

	public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
		super();
		this.employeeServiceImpl = employeeServiceImpl;
	}
	
	
	@PostMapping("employees/employee")
	public List<Employee> addNewEmployee(
			@RequestBody Employee employee) {

		// Console
		log.info("Request received to add new department");
		log.info(employee.toString());

		List<Employee> employeeList = employeeServiceImpl.addNewEmployee(employee);

		// Console
		log.info("New department added successfully");
		log.info(employeeList.toString());

		
		return employeeList;
	}
	
	
	@GetMapping("employees/{employeeId}")
	public Employee getSingleEmployee(@PathVariable int employeeId) {
		log.info("Request received to retrive employee details");
		log.info("CustomerId :: " + employeeId);

		Employee employee = employeeServiceImpl.getEmployeeByEmployeeId(employeeId);

		log.info("Department details retrived successfully");
		log.info(employee.toString());

		

		return employee;

	}

	
	
}
