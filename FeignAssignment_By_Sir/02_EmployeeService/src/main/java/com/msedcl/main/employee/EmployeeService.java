package com.msedcl.main.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.msedcl.main.client.DepartmentFeignClient;
import com.msedcl.main.dto.DepartmentDTO;
import com.msedcl.main.dto.EmployeeDTO;
import com.msedcl.main.dto.EmployeeRequestDTO;

import lombok.AllArgsConstructor;

@Service
public class EmployeeService {
	 private final DepartmentFeignClient departmentFeignClient;
		private List<EmployeeDTO> employeeList=new ArrayList<>();
     public EmployeeService(DepartmentFeignClient departmentFeignClient) {
		super();
		this.departmentFeignClient = departmentFeignClient;
	}

	
	
	public EmployeeDTO getEmployeeByEmployeeId(int employeeId)
	{
		for(EmployeeDTO employeeDto:employeeList)
		{
			if(employeeDto.getEmployeeId()==employeeId)
				return employeeDto;
		}
   return null;
	}
	
	
	
	public EmployeeDTO addNewEmployee(EmployeeRequestDTO employeeRequestDTO) {
		ResponseEntity<DepartmentDTO> response = departmentFeignClient
				.getDepartment(employeeRequestDTO.getDepartmentId());
		if (response != null) {
			EmployeeDTO employeeDTO = new EmployeeDTO(employeeRequestDTO.getEmployeeId(), employeeRequestDTO.getName(),
					employeeRequestDTO.getSalary(), response.getBody());
			employeeList.add(employeeDTO);
			return employeeDTO;
		}
		return null;
	}
}
