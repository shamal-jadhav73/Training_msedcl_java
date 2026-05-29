package com.msedcl.main.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.service.EmployeeService;

@RestController
@RequestMapping("employeecrudapi")
public class EmployeeCRUDController {
	private EmployeeService employeeService;

	public EmployeeCRUDController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	// URL=http://localhost:8080/employeecrudapi/employees/101
	// method=delete
	@DeleteMapping("employees/{employeeId}")
	public boolean deleteEmployee(@PathVariable int employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}

	// URL=http://localhost:8080/employeecrudapi/employees/employee
	// METHOD=PUT
	@PutMapping("employees/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	// URL=http://localhost:8080/employeecrudapi/employees/employee/103
	// METHOD=Post
	@PostMapping("employees/employee")
	public Employee addNewEmployee(@RequestBody Employee employee) {
		return employeeService.addNewEmployee(employee);

	}

	// URL=http://localhost:8080/employeecrudapi/employees/101
//mthod=get	   

	@GetMapping("employees/{employeeId}")
	public Employee getSingleEmployee(@PathVariable int employeeId) {
		return employeeService.getEmployeeByEmployeeId(employeeId);
	}

	// URL=http://localhost:8080/employeecrudapi/employees
	// mthod=get
	@GetMapping("employees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployees();
	}
}
