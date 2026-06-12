package com.msedcl.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@RequestMapping("authenticationapi")
@RestController
public class AuthController {
	 
	@GetMapping("test")
	public ResponseEntity<String> test()
	{
		log.info("Request Received.!");
		return ResponseEntity.status(HttpStatus.OK).body("Its Working...!!!");
	}

}
