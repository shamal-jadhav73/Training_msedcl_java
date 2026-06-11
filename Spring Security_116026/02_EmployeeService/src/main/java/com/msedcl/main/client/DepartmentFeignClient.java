package com.msedcl.main.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.msedcl.main.dto.DepartmentDTO;

@FeignClient(name="department-service",path="/departmentapi",fallback = DepartmentFallBack.class)
public interface DepartmentFeignClient {
	
	@GetMapping("department")
	public ResponseEntity<DepartmentDTO> getDepartment(@RequestParam int departmentId);

}
