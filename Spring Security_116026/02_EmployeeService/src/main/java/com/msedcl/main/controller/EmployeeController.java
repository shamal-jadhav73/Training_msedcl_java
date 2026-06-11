package com.msedcl.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.dto.EmployeeDTO;
import com.msedcl.main.dto.EmployeeRequestDTO;
import com.msedcl.main.employee.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("employeeapi")
@RestController
@AllArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;
	
	
	@GetMapping("employee")
	public ResponseEntity<EmployeeDTO> getSingleEmployee(@RequestParam int employeeId)
	{
		EmployeeDTO employeeDTO =employeeService.getEmployeeByEmployeeId(employeeId);
		if(employeeDTO!=null)
		{
			return ResponseEntity.status(HttpStatus.OK).body(employeeDTO);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PostMapping("employee")
	public ResponseEntity<EmployeeDTO> addNewEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO)
	{
		EmployeeDTO employeeDTO = employeeService.addNewEmployee(employeeRequestDTO);
		if(employeeDTO!=null)
		{
			return ResponseEntity.status(HttpStatus.OK).body(employeeDTO);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

}
