package com.msedcl.main.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.msedcl.main.entity.Employee;

@DataJpaTest
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	void getEmployee()
	{
		Employee employee=new Employee(0,"Reema",1000);
		
	Employee existingEmployee=employeeRepository.save(employee);
	Optional<Employee> searchedEmployee=employeeRepository.findById(existingEmployee.getEmployeeId());
	assertTrue(searchedEmployee.isPresent());
	}
}
