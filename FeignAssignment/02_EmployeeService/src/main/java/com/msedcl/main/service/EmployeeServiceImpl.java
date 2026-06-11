package com.msedcl.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.client.DepartmentFeignClient;
import com.msedcl.main.dto.Department;
import com.msedcl.main.dto.Employee;

@Service
public class EmployeeServiceImpl {
	
	public EmployeeServiceImpl(DepartmentFeignClient departmentFeignClient) {
		super();
		this.departmentFeignClient = departmentFeignClient;
	}


	private final DepartmentFeignClient departmentFeignClient;
	List<Employee> employeeList = new ArrayList<>();
	
	public List<Employee> addNewEmployee(Employee employee)
	{
		employeeList.add(employee);
		return employeeList;
	}
	
	
    public Employee getEmployeeByEmployeeId(int employeeId)
    {
    	Employee employee=new  Employee();
    	for(Employee e:employeeList)
    	{
    		if(e.getEmployeeId()==employeeId)
    			employee=e;
    	}
    	Department department=departmentFeignClient.getSingleDepartment(employee.getDepartment().getDepartmentId());
    	employee.setDepartment(department);
    	return employee;
    }
	

}
