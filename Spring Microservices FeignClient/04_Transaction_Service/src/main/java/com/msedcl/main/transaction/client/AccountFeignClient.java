package com.msedcl.main.transaction.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.msedcl.main.transaction.common.ApiResponse;
import com.msedcl.main.transaction.dto.AccountResponseDTO;
import com.msedcl.main.transaction.dto.BalanceUpdateRequestDTO;

import jakarta.validation.Valid;


@FeignClient(name="account-service",path="/accountapi")
public interface AccountFeignClient {
	
	@GetMapping("/accounts/account/{accountId}")
	public ResponseEntity<ApiResponse<AccountResponseDTO>> getAccountByAccountId(@PathVariable int accountId);
	@PutMapping("/accounts/updateAccount")
	public ResponseEntity<ApiResponse<AccountResponseDTO>> updateAccount(@Valid @RequestBody BalanceUpdateRequestDTO balanceUpdateRequestDTO);

}
