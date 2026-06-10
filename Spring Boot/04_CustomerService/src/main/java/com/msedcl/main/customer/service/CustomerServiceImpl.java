package com.msedcl.main.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.msedcl.main.customer.dto.CustomerRequestDTO;
import com.msedcl.main.customer.dto.CustomerResponseDTO;
import com.msedcl.main.customer.entity.Customer;
import com.msedcl.main.customer.exception.CustomerNotFoundException;
import com.msedcl.main.customer.mapper.CustomerMapper;
import com.msedcl.main.customer.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	@Override
	public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
		
//		Customer customer = CustomerMapper.toEntity(customerRequestDTO);
//		Customer savedCustomer = customerRepository.save(customer);
//		CustomerResponseDTO customerResponseDTO = CustomerMapper.toDTO(savedCustomer);
//      return customerResponseDTO;
		
//		Customer customer = CustomerMapper.toEntity(customerRequestDTO);
//		Customer savedCustomer = customerRepository.save(customer);
//      return CustomerMapper.toDTO(savedCustomer);
		
//		Customer savedCustomer = customerRepository.save(CustomerMapper.toEntity(customerRequestDTO));
//      return CustomerMapper.toDTO(savedCustomer);
		
		return CustomerMapper.toDTO(customerRepository.save(CustomerMapper.toEntity(customerRequestDTO)));
	}

	@Override
	public CustomerResponseDTO getCustomerByCustomerId(int customerId) {
		
		Optional<Customer> optionalCustomer=customerRepository.findById(customerId);
		if(optionalCustomer.isPresent())
		{
			CustomerResponseDTO customerResponseDTO=CustomerMapper.toDTO(optionalCustomer.get());
			return customerResponseDTO;
		}
		
		throw new CustomerNotFoundException("Invalid ConsumerId::"+ customerId);
	}

	

	@Override
	public CustomerResponseDTO getCustomerByEmail(String email) {
		
		
		Optional<Customer> optionalCustomer=customerRepository.findByEmail(email);
		if(optionalCustomer.isPresent())
		{
			CustomerResponseDTO customerResponseDTO=CustomerMapper.toDTO(optionalCustomer.get());
			return customerResponseDTO;
		}
		
		throw new CustomerNotFoundException("Invalid EmailId::"+ email);
	}

	@Override
	public List<CustomerResponseDTO> getAllCustomers() {
		
		List<Customer> cutomerList= customerRepository.findAll();
		List<CustomerResponseDTO> customerResponseDTOList=new ArrayList<>();
		
		for(Customer customer: cutomerList)
		{
			customerResponseDTOList.add(CustomerMapper.toDTO(customer));
		}
		return customerResponseDTOList;
	}

}
