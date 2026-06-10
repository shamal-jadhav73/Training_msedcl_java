package com.msedcl.main.transaction.controller;

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


import com.msedcl.main.transaction.common.ApiResponse;
import com.msedcl.main.transaction.dto.AccountResponseDTO;
import com.msedcl.main.transaction.dto.CustomerContactDTO;
import com.msedcl.main.transaction.dto.TransactionRequestDTO;
import com.msedcl.main.transaction.dto.TransactionResponseDTO;
import com.msedcl.main.transaction.service.TransactionService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Validated
@Slf4j
@RestController
@RequestMapping("transactionapi")
public class TransactionController {
	
	private final TransactionService transactionService;
	private CustomerContactDTO customerContactDTO;
	
	@Value("${build.version}")
	private String buildVersion;
	
	public TransactionController(TransactionService transactionService,CustomerContactDTO customerContactDTO) {
		super();
		this.transactionService = transactionService;
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

	@PostMapping("transaction/withdraw")
	public ResponseEntity<ApiResponse<TransactionResponseDTO>> withdrawAmount(@Valid @RequestBody TransactionRequestDTO transactionRequestDTO){
		
		//console
		log.info("Request received to withdraw Balance");
		log.info(transactionRequestDTO.toString());
		
		TransactionResponseDTO transactionResponseDTO=transactionService.withdrawAmount(transactionRequestDTO);
		
		//console
		log.info("Account balance updated successfully.");
		log.info(transactionResponseDTO.toString());
		
		
		//Response
		ApiResponse<TransactionResponseDTO> apiResponse=new ApiResponse<TransactionResponseDTO>("Updated","Amount Withdrawed", transactionResponseDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
	}
	
	
	@PostMapping("transaction/deposit")
	public ResponseEntity<ApiResponse<TransactionResponseDTO>> depositAmount(@Valid @RequestBody TransactionRequestDTO transactionRequestDTO){
		
		//console
		log.info("Request received to deposit Balance");
		log.info(transactionRequestDTO.toString());
		
		TransactionResponseDTO transactionResponseDTO=transactionService.depositAmount(transactionRequestDTO);
		
		//console
		log.info("Account balance updated successfully.");
		log.info(transactionResponseDTO.toString());
		
		
		//Response
		ApiResponse<TransactionResponseDTO> apiResponse=new ApiResponse<TransactionResponseDTO>("Updated","Amount Deposited", transactionResponseDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
	}
	
	@GetMapping("transactions/account/{accountId}")
	public ResponseEntity<ApiResponse<List<TransactionResponseDTO>>> getTransactionByAccountId(@PathVariable int accountId){
		
		//console
		log.info("Getting Transactions by account Id.."+accountId);
		
		List<TransactionResponseDTO> transactionResponseDTOList=transactionService.getTransactionsByAccountId(accountId);
		
		
		//console
		log.info("find response generated");
		log.info(transactionResponseDTOList.toString());
		
		
		//Response
		ApiResponse<List<TransactionResponseDTO>> apiResponse=new ApiResponse<List<TransactionResponseDTO>>("FOUND","Transactions found by Account Id", transactionResponseDTOList);
		return ResponseEntity.status(HttpStatus.FOUND).body(apiResponse);
	}

}
