package com.msedcl.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/myaccounts")
@RestController
public class AccountsController {
	 
	@GetMapping
	public ResponseEntity<String> testMyAccounts()
	{
		return ResponseEntity.status(HttpStatus.OK).body("My Accounts is Working");
	}

}
