package com.msedcl.main.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.msedcl.main.domain.LoginDetails;


@Component
@Scope(scopeName="prototype")
public class LoginService {

	public boolean validateLoginDetails(LoginDetails loginDetails) {

		if (loginDetails.getLoginId().equals("ADMIN") && loginDetails.getPassword().equals("Admin@123"))
			return true;
		else
			return false;

	}
	public LoginService() {
		// TODO Auto-generated constructor stub
		System.out.println("Default Constructor called");
	}
}