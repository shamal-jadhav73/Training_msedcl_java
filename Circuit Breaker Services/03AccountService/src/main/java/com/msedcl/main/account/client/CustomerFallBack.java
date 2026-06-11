package com.msedcl.main.account.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.msedcl.main.account.common.ApiResponse;
import com.msedcl.main.account.dto.AccountResponseDTO;
import com.msedcl.main.account.dto.CustomerResponseDTO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class CustomerFallBack implements CustomerFeignClient {

	@Override
	public ResponseEntity<ApiResponse<CustomerResponseDTO>> getSingleCustomer(int customerId) {
		
		//Response
				ApiResponse<CustomerResponseDTO> apiResponse=new ApiResponse<>("ERROR","CustomerFallBack ", null);
		
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(apiResponse);
	}

}
