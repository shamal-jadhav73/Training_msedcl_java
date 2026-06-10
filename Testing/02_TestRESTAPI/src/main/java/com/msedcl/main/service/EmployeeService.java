package com.msedcl.main.service;

import org.springframework.stereotype.Service;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	public Employee getEmployeeByEmployeeId(int employeeId)
	{
		return employeeRepository.findById(employeeId)
        .orElseThrow(()->new RuntimeException("Employee Not Found"));
	}

}
