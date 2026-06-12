package com.msedcl.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.service.UserServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("userauthenticationapi")
@AllArgsConstructor
public class UserController {
	
	private final  UserServiceImpl userService;
	/*
	 * @PostMapping("validate") public ResponseEntity<String>
	 * validateUserDetails(@RequestParam String userName,@RequestParam String
	 * password) { if(userService.validate(userName, password)) return
	 * ResponseEntity.status(HttpStatus.OK).body("User Validated Successfully");
	 * else return ResponseEntity.status(HttpStatus.NOT_FOUND).
	 * body("Invalid UserName or Password");
	 * 
	 * }
	 */
	
	
	  @PostMapping("validate") public ResponseEntity<String>
	  validateUserDetails(@RequestParam String userName,@RequestParam String password) 
	  { 
		  
	   
		  return ResponseEntity
				  .status(HttpStatus.OK)
				  .body(userService.validate(userName, password));
	  
	  }
	 
	
	

}
