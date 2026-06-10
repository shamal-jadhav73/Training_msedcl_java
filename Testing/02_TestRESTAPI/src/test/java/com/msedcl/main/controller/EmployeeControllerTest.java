package com.msedcl.main.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.service.EmployeeService;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@MockitoBean
	EmployeeService employeeService;
	
	@Test
	void getEmployeeTest() throws Exception
	{
		
		//preTest configuration
		
		Employee employee=new Employee(1,"Seema",1000);
		when(employeeService.getEmployeeByEmployeeId(1)).thenReturn(employee);
		
		mockMvc.perform(
				get("/employeecrudapi/employees/employee/1"))
		         .andExpect(status().isOk())
		         .andExpect(jsonPath("$.employeeId").value(1))
		         .andExpect(jsonPath("$.name").value("Seema"))
		         .andExpect(jsonPath("$.salary").value(1000));
		
	}
	
	@Test
	void saveEmployeeTest() throws Exception
	{
		//pre test configuration
		
		//Return below employee after save operation
		Employee employee=new Employee(1,"Seema",1000);
		
		when(employeeService.addEmployee(any(Employee.class))).thenReturn(employee);
		mockMvc.perform(post("/employeecrudapi/employees/employee").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(employee)))
		.andExpect(status().isCreated())
        .andExpect(jsonPath("$.employeeId").value(1))
        .andExpect(jsonPath("$.name").value("Seema"))
        .andExpect(jsonPath("$.salary").value(1000));;
	}

}
