package com.msedcl.main.mapper;

import com.msedcl.main.dto.EmployeeRequestDTO;
import com.msedcl.main.dto.EmployeeResponseDTO;
import com.msedcl.main.entity.Employee;

public class EmployeeMapper {
	//convert DTO to Entity
	
	public static Employee mapEmployeeDTOTOEmployee(EmployeeRequestDTO employeeRequestDTO)
	{
		Employee employee = new Employee();
		employee.setEmployeeId(employeeRequestDTO.getEmployeeId());
		employee.setName(employeeRequestDTO.getName());
		employee.setSalary(employeeRequestDTO.getSalary());
		return employee;
	}
	
	//convert Entity to DTO
	
	public static EmployeeResponseDTO mapEmployeeToEmployeeResponseDTO(Employee employee)
	{
		EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
		employeeResponseDTO.setEmployeeId(employee.getEmployeeId());
		employeeResponseDTO.setName(employee.getName());
		employeeResponseDTO.setSalary(employee.getSalary());
		return employeeResponseDTO;
	}

}
