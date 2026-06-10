package com.msedcl.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.msedcl.main.dto.EmployeeDTO;

@Controller
public class HelloWorldController {
	
	private List<EmployeeDTO> employeeDTOList=new ArrayList<>();
	public HelloWorldController() {
		employeeDTOList.add(new EmployeeDTO(101, "Test 1", 1000));
		employeeDTOList.add(new EmployeeDTO(102, "Test 2", 1000));
		employeeDTOList.add(new EmployeeDTO(103, "Test 3", 1000));
	}

	
	@PostMapping("/saveemp")
	public String saveEmployee(EmployeeDTO employeeDTO)
    {
		System.out.println("EmployeeDTO received in controller");
		
		System.out.println(employeeDTO.toString());
		employeeDTOList.add(employeeDTO);
		System.out.println("Employee DTO added in list");
		return "redirect:/employees";
	}
	
	@GetMapping("addnew")
	public ModelAndView showAddNewEmployee()
	{
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.setViewName("employee-form");
		
		//creating empty object to connect form 
		EmployeeDTO employeeDTO=new EmployeeDTO();
		modelAndView.addObject("employee", employeeDTO);
		return modelAndView;
	}
	
	
	@GetMapping("/")
	public String showHomePage()
	{
		return "index";
	}
	
	@GetMapping("process")
	public ModelAndView printMessage(@RequestParam("message") String message)
	{
		System.out.println(message);
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.setViewName("third");
		modelAndView.addObject("message",message);
		return modelAndView;
	}
	
	@GetMapping("employees")
	public ModelAndView printAllEmployees()
	{
		System.out.println("Print All Employees");
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.setViewName("employee-list");
		modelAndView.addObject("employeeList",employeeDTOList);
		return modelAndView;
	}
	
	
	@GetMapping("next")
	public String showNextPage()
	{
		
		return "second";
		
	}
}
