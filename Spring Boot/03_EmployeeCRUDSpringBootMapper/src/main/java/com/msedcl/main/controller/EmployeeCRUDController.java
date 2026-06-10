package com.msedcl.main.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.dto.EmployeeRequestDTO;
import com.msedcl.main.dto.EmployeeResponseDTO;
import com.msedcl.main.dto.ResponseDTO;
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
	public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int employeeId) {
		boolean result= employeeService.deleteEmployee(employeeId);
		if(result)
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO("Employee Deleted with employee id:"+employeeId));
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO("Invalid employee id:"+employeeId));
	}

	// URL=http://localhost:8080/employeecrudapi/employees/employee
	// METHOD=PUT
	@PutMapping("employees/employee")
	public EmployeeResponseDTO updateEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
		return employeeService.updateEmployee(employeeRequestDTO);
	}

	// URL=http://localhost:8080/employeecrudapi/employees/employee
	// METHOD=Post
	@PostMapping("employees/employee")
	public EmployeeResponseDTO addNewEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
		return employeeService.addNewEmployee(employeeRequestDTO);

	}

	// URL=http://localhost:8080/employeecrudapi/employees/101
//mthod=get	   

	@GetMapping("employees/{employeeId}")
	public EmployeeResponseDTO getSingleEmployee(@PathVariable int employeeId) {
		return employeeService.getEmployeeByEmployeeId(employeeId);
	}

	// URL=http://localhost:8080/employeecrudapi/employees
	// mthod=get
	@GetMapping("employees")
	public List<EmployeeResponseDTO> getAllEmployee() {
		return employeeService.getAllEmployees();
	}
}
