package com.msedcl.main.customer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.customer.common.ApiResponse;
import com.msedcl.main.customer.dto.CustomerRequestDTO;
import com.msedcl.main.customer.dto.CustomerResponseDTO;
import com.msedcl.main.customer.service.CustomerService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Validated
@Slf4j
@RestController
@RequestMapping("customerapi")
@AllArgsConstructor
public class CustomerController {
	
	private final CustomerService customerService;
	
	
	
	@PostMapping("customers/customer")
	public ResponseEntity<ApiResponse<CustomerResponseDTO>> addNewCustomer(@Valid   @RequestBody CustomerRequestDTO customerRequestDTO)
	{
		
		//console
		log.info("Request received to add a new customer");
		log.info(customerRequestDTO.toString());
		
		CustomerResponseDTO customerResponseDTO=customerService.createCustomer(customerRequestDTO);
		
		// console
		log.info("New Customer added successfully");
		log.info(customerResponseDTO.toString());
		
		//response
		ApiResponse<CustomerResponseDTO> apiResponse=new ApiResponse<CustomerResponseDTO>("CREATED","New Customer Created Successfully",customerResponseDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
	}
	
	@GetMapping("customers/{customerId}")
	public ResponseEntity<ApiResponse<CustomerResponseDTO>> getSingleCustomer( @PathVariable int customerId)
	{
		log.info("Request received to retrieve customer details");
		log.info("CustomerId ::" +customerId);
		
	
		
		CustomerResponseDTO customerResponseDTO=customerService.getCustomerByCustomerId(customerId);
		
		log.info("Consumer retrieved Successfully");
		log.info(customerResponseDTO.toString());
		
		//response
		ApiResponse<CustomerResponseDTO> apiResponse=new ApiResponse<CustomerResponseDTO>("FOUND","Customer details retrieved Successfully",customerResponseDTO);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(apiResponse);
	}
	
	
	@GetMapping("customers/email/{email}")
	public ResponseEntity<ApiResponse<CustomerResponseDTO>> getCustomerByEmailId( @PathVariable String email)
	{
		log.info("Request received to retrieve customer details through email id");
	    log.info("CustomerId ::" +email);
	
	    CustomerResponseDTO customerResponseDTO=customerService.getCustomerByEmail(email);
	    
	    log.info("Consumer retrieved Successfully");
		log.info(customerResponseDTO.toString());
		
		//response
				ApiResponse<CustomerResponseDTO> apiResponse=new ApiResponse<CustomerResponseDTO>("FOUND","Customer details retrieved Successfully",customerResponseDTO);
				
				return ResponseEntity.status(HttpStatus.FOUND).body(apiResponse);
	    
	}
	
	
	
	@GetMapping("customers")
	public ResponseEntity<ApiResponse<List<CustomerResponseDTO>>> getAllCustomers() {
		log.info("Request received to retrive all customer details");
		List<CustomerResponseDTO> customerResponseDTOList = customerService.getAllCustomers();
		log.info("All Customers retrived successfully");
		customerResponseDTOList.forEach(c -> log.info(c.toString()));

		ApiResponse<List<CustomerResponseDTO>> apiResponse = new ApiResponse<List<CustomerResponseDTO>>("OK",
				"All Customers Retrived Successfully", customerResponseDTOList);

		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}
	
	
	

	
}
