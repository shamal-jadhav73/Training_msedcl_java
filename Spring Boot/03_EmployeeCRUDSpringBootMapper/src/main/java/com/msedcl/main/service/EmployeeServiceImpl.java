package com.msedcl.main.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.msedcl.main.dto.EmployeeRequestDTO;
import com.msedcl.main.dto.EmployeeResponseDTO;
import com.msedcl.main.dto.ResponseDTO;
import com.msedcl.main.entity.Employee;
import com.msedcl.main.mapper.EmployeeMapper;
import com.msedcl.main.repository.EmployeeRepository;
import com.msedcl.main.repository.EmployeeRepositoryImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private  EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeResponseDTO addNewEmployee(EmployeeRequestDTO employeeRequestDTO) {
		  Employee employee = EmployeeMapper.mapEmployeeDTOTOEmployee(employeeRequestDTO);
		  Employee savedEmployee=employeeRepository.addNewEmployee(employee);
		  EmployeeResponseDTO employeeResponseDTO =EmployeeMapper.mapEmployeeToEmployeeResponseDTO(savedEmployee);
		  return employeeResponseDTO;
	}

	@Override
	public EmployeeResponseDTO updateEmployee(EmployeeRequestDTO employeeRequestDTO) {
		Employee employee = EmployeeMapper.mapEmployeeDTOTOEmployee(employeeRequestDTO);
		  Employee updatedEmployee=employeeRepository.updateEmployee(employee);
		  EmployeeResponseDTO employeeResponseDTO =EmployeeMapper.mapEmployeeToEmployeeResponseDTO(updatedEmployee);
		  return employeeResponseDTO;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
	
		return employeeRepository.deleteEmployee(employeeId);
	}

	@Override
	public EmployeeResponseDTO getEmployeeByEmployeeId(int employeeId) {
		
		Employee existingEmployee=employeeRepository.getEmployeeByEmployeeId(employeeId);
		EmployeeResponseDTO employeeResponseDTO =EmployeeMapper.mapEmployeeToEmployeeResponseDTO(existingEmployee);
		  return employeeResponseDTO;
		
	}

	@Override
	public List<EmployeeResponseDTO> getAllEmployees() {
		List<Employee> employeeList = employeeRepository.getAllEmployees();
		List<EmployeeResponseDTO> employeeResponseDTOList= new ArrayList<>();
		for(Employee employee:employeeList)
		{
			EmployeeResponseDTO employeeResponseDTO = EmployeeMapper.mapEmployeeToEmployeeResponseDTO(employee);
			employeeResponseDTOList.add(employeeResponseDTO);
		}
		
		return employeeResponseDTOList;
	}

	@Override
	public List<EmployeeResponseDTO> getAllEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCountOfEmployees() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<EmployeeResponseDTO> getMaxSalariedEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
