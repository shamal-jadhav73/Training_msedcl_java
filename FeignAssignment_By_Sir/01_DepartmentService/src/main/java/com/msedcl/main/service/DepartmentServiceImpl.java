package com.msedcl.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.msedcl.main.dto.DepartmentDTO;

@Service
public class DepartmentServiceImpl {
	
	private List<DepartmentDTO> departmentList=new ArrayList<>();
	
	
	public DepartmentServiceImpl() {
		departmentList.add(new DepartmentDTO(1, "IT"));
		 departmentList.add(new DepartmentDTO(2, "HR"));
		 departmentList.add(new DepartmentDTO(3,  "Technical"));
		 departmentList.add(new DepartmentDTO(4,  "Finance"));
	}
	 
	 
//	public void addNewDepartment(int departmentId,String departmentName) {
//	
//	DepartmentDTO newDept= new DepartmentDTO(departmentId,departmentName);
//	departmentList.add(newDept);
//
//	}
	
	public DepartmentDTO getDepartmentByDepartmentId(int departmentId)
	{
		  Optional<DepartmentDTO> department = departmentList.stream()
				  .filter(dept -> dept.getDepartmentId() == departmentId)
		            .findFirst();
		  return department.get();
	
	}

	public DepartmentDTO addNewDepartment(DepartmentDTO departmentDTO) {
		
		departmentList.add(departmentDTO);
		
		return departmentDTO;

}
}
