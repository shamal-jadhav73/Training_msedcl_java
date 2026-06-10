package com.msedcl.main.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.account.common.ApiResponse;
import com.msedcl.main.account.dto.AccountRequestDTO;
import com.msedcl.main.account.dto.AccountResponseDTO;
import com.msedcl.main.account.dto.BalanceUpdateRequestDTO;
import com.msedcl.main.account.dto.CustomerContactDTO;
import com.msedcl.main.account.service.AccountService;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Validated
@Slf4j
@RestController
@RequestMapping("accountapi")
public class AccountController {

	private final AccountService accountService;
	@Value("${build.version}")
	private String buildVersion;
	private CustomerContactDTO customerContactDTO;

	public AccountController(AccountService accountService,CustomerContactDTO customerContactDTO) {
		super();
		this.accountService = accountService;
		this.customerContactDTO=customerContactDTO;
	}
	
	@GetMapping("contact-details")
	public ResponseEntity<CustomerContactDTO> printCustomerContact()
	{
		return ResponseEntity.status(HttpStatus.OK).body(customerContactDTO);
	}


	@GetMapping("build-version")
	public ResponseEntity<String> printBuildVersion()
	{
		return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
	}

	@PostMapping("accounts/account")
	public ResponseEntity<ApiResponse<AccountResponseDTO>> createNewAccount(
			@Valid @RequestBody AccountRequestDTO accountRequestDTO) {
		
		// Console
				log.info("Request received to create new Account");
				log.info(accountRequestDTO.toString());

		
		AccountResponseDTO accountResponseDTO=accountService.createNewAccount(accountRequestDTO);
		
		ApiResponse<AccountResponseDTO> apiResponse = new ApiResponse<AccountResponseDTO>("CREATED",
				"New Account Created Successfully", accountResponseDTO);

		return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
	}
	
	
	
	@GetMapping("accounts/account/{accountId}")
	public ResponseEntity<ApiResponse<AccountResponseDTO>> getAccountByAccountId(@PathVariable int accountId){
		
		//console
		log.info("Getting account by Account Id.."+accountId);
		
		AccountResponseDTO accountResponseDTO=accountService.getAccountByAccountId(accountId);
		
		
		//console
		log.info("find response generated");
		log.info(accountResponseDTO.toString());
		
		
		//Response
		ApiResponse<AccountResponseDTO> apiResponse=new ApiResponse<AccountResponseDTO>("OK","Account Found by the controller", accountResponseDTO);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}
	
	@GetMapping("accounts/customer/{customer}")
	public ResponseEntity<ApiResponse<List<AccountResponseDTO>>> getAccountByCustomerId(@PathVariable int customer){
		
		//console
		log.info("Getting account by Customer Id.."+customer);
		
		List<AccountResponseDTO> accountResponseDTOs=accountService.getAccountByCustomertId(customer);
		
		
		//console
		log.info("find response generated");
		log.info(accountResponseDTOs.toString());
		
		
		//Response
		ApiResponse<List<AccountResponseDTO>> apiResponse=new ApiResponse<List<AccountResponseDTO>>("FOUND","Account Found by the controller", accountResponseDTOs);
		return ResponseEntity.status(HttpStatus.FOUND).body(apiResponse);
	}
	
	@PutMapping("accounts/updateAccount")
	public ResponseEntity<ApiResponse<AccountResponseDTO>> updateAccount(@Valid @RequestBody BalanceUpdateRequestDTO balanceUpdateRequestDTO){
		
		//console
		log.info("Request received to update Balance");
		log.info(balanceUpdateRequestDTO.toString());
		
		AccountResponseDTO accountResponseDTO=accountService.updateAccountBalance(balanceUpdateRequestDTO);
		
		//console
		log.info("Account balance updated successfully.");
		log.info(accountResponseDTO.toString());
		
		
		//Response
		ApiResponse<AccountResponseDTO> apiResponse=new ApiResponse<AccountResponseDTO>("Updated","Balance updated", accountResponseDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
	}

}
