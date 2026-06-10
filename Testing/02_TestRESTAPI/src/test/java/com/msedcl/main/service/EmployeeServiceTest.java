package com.msedcl.main.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.repository.EmployeeRepository;

import jakarta.inject.Inject;

@ExtendWith(MockitoExtension.class) // in order to create mock objects we need mockitoExtension
class EmployeeServiceTest {
	
	@Mock  // create mock object
	private EmployeeRepository employeeRepository;
	
	@InjectMocks //it will create real object of Employee Service and inject the mock
	private EmployeeService employeeService;

	
	@Test
	void testGetEmployee()
	{
		Employee employee = new Employee(101,"Reema",1000);
		
		when(employeeRepository.findById(101)).thenReturn(Optional.of(employee));
		Employee existingEmployee= employeeService.getEmployeeByEmployeeId(101);
		
		assertEquals("Reema", existingEmployee.getName());
	}
}
