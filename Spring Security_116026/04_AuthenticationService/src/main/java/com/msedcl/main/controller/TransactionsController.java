package com.msedcl.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/mytransactions")
@RestController
public class TransactionsController {
	 
	@GetMapping
	public ResponseEntity<String> testMyTransactions()
	{
		return ResponseEntity.status(HttpStatus.OK).body("My Transactions is Working");
	}

}
