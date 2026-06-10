package com.msedcl.main.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.msedcl.main.customer.dto.CustomerRequestDTO;
import com.msedcl.main.customer.service.CustomerService;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CustomerController {
	private final CustomerService customerService;

	@GetMapping("/")
	public ModelAndView printALLCustomers() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addObject("customers", customerService.getAllCustomers());
		return modelAndView;
	}

	
	@PostMapping("/savecustomer")
	public String saveCustomer(@Valid CustomerRequestDTO customerRequestDTO,BindingResult bindingResult)
	{
		
		if(bindingResult.hasErrors())
		{
			return "customer-form";
		}
		customerService.addNewCustomer(customerRequestDTO);
		return "redirect:/";
	}
	
	@GetMapping("/newcustomer")
	public ModelAndView showAddNewCustomerPage()
	{
		ModelAndView modelAndView= new ModelAndView();
		CustomerRequestDTO customerRequestDTO=new CustomerRequestDTO();
		modelAndView.setViewName("customer-form");
		modelAndView.addObject("customerRequestDTO", customerRequestDTO);
		return modelAndView;
		
	}
	

}
