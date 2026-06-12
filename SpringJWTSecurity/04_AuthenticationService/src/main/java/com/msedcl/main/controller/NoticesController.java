package com.msedcl.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/notices")
@RestController
public class NoticesController {
	 
	@GetMapping
	public ResponseEntity<String> testNotices()
	{
		return ResponseEntity.status(HttpStatus.OK).body("Notices is Working");
	}

}
