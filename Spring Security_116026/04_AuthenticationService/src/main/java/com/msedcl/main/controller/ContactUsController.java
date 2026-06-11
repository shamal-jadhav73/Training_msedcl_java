package com.msedcl.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/contact-us")
@RestController
public class ContactUsController {
	 
	@GetMapping
	public ResponseEntity<String> testContactUs()
	{
		return ResponseEntity.status(HttpStatus.OK).body("Contact Us is Working");
	}

}
