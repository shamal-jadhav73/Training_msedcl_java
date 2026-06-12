package com.msedcl.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.dto.DepartmentDTO;
import com.msedcl.main.service.DepartmentServiceImpl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@RequestMapping("departmentapi")
@RestController
@AllArgsConstructor
public class DepartmentController {
	
	private final DepartmentServiceImpl departmentServiceImpl;
	
	@GetMapping("department")
	public ResponseEntity<DepartmentDTO> getDepartment(@RequestParam int departmentId)
	{
		DepartmentDTO departmentDTO = departmentServiceImpl.getDepartmentByDepartmentId(departmentId);
		if (departmentDTO != null) {
			return ResponseEntity.status(HttpStatus.OK).body(departmentDTO);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PostMapping("department")
	public ResponseEntity<DepartmentDTO> addNewDepartment(@RequestBody DepartmentDTO departmentDTO) {
		DepartmentDTO existingDepartment = departmentServiceImpl.addNewDepartment(departmentDTO);
		if (departmentDTO != null) {
			return ResponseEntity.status(HttpStatus.OK).body(existingDepartment);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	

}
