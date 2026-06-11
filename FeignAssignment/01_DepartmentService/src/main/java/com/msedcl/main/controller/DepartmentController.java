package com.msedcl.main.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.dto.Department;
import com.msedcl.main.service.DepartmentServiceImpl;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
@RequestMapping("departmentapi")
public class DepartmentController {
	
	DepartmentServiceImpl departmentServiceImpl;
	
	public DepartmentController(DepartmentServiceImpl departmentServiceImpl) {
		super();
		this.departmentServiceImpl = departmentServiceImpl;
	}


	@PostMapping("departments/department")
	public List<Department> addNewCustomer(
			@RequestBody Department department) {

		// Console
		log.info("Request received to add new department");
		log.info(department.toString());

		List<Department> departmentList = departmentServiceImpl.addNewDepartment(department);

		// Console
		log.info("New department added successfully");
		log.info(departmentList.toString());

		
		return departmentList;
	}
	
	
	@GetMapping("departments/{departmentId}")
	public Department getSingleDepartment(@PathVariable int departmentId) {
		log.info("Request received to retrive customer details");
		log.info("CustomerId :: " + departmentId);

		Department department = departmentServiceImpl.getDepartmentByDepartmentId(departmentId);

		log.info("Department details retrived successfully");
		log.info(department.toString());

		

		return department;

	}


}
