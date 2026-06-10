package com.msedcl.main.service;

import java.util.List;

import com.msedcl.main.dto.EmployeeRequestDTO;
import com.msedcl.main.dto.EmployeeResponseDTO;

public interface EmployeeService {
	
	EmployeeResponseDTO addNewEmployee(EmployeeRequestDTO employeeRequestDTO);
	//update Employee
	EmployeeResponseDTO updateEmployee(EmployeeRequestDTO employeeRequestDTO);
	//delete employee by employee id
	boolean deleteEmployee(int employeeId);
	//select single employee
	EmployeeResponseDTO getEmployeeByEmployeeId(int employeeId);
	//list of all employees
	List<EmployeeResponseDTO> getAllEmployees();
	List<EmployeeResponseDTO> getAllEmployeeByName(String name);
	long getCountOfEmployees();
	List<EmployeeResponseDTO> getMaxSalariedEmployee();

}
