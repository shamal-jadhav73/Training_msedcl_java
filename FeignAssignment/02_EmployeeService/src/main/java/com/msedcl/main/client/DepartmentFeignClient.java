package com.msedcl.main.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.msedcl.main.dto.Department;

@FeignClient(name="department-service",path="departmentapi")
public interface DepartmentFeignClient {
	
	@GetMapping("departments/{departmentId}")
	public Department getSingleDepartment(@PathVariable int departmentId);

}
