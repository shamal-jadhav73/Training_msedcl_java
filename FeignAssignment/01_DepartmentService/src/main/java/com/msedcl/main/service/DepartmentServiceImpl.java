
package com.msedcl.main.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.dto.Department;
@Service
public class DepartmentServiceImpl {
	
List<Department> departmentList=new ArrayList<>();
	
	public List<Department> addNewDepartment(Department department)
	{
		departmentList.add(department);
		return departmentList;
	}
	
	public Department getDepartmentByDepartmentId(int departmentId)
	{
		Department department=new Department();
		for(Department d:departmentList)
		{
			if(d.getDepartmentId()==departmentId)
			{
				return d;
			}
		}
		
		throw new RuntimeException("Department not found with id: " + departmentId);
	}

}
