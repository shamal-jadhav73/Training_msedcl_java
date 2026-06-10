package com.msedcl.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("employeecrudapi")
public class EmployeeController {
	
private EmployeeService employeeService;

@PostMapping("employees/employee")
public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
{
	return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(employee));
}


@GetMapping("employees/employee/{employeeId}")
public ResponseEntity<Employee> getEmployee(@PathVariable Integer employeeId)
{
	return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeByEmployeeId(employeeId));
}

}
