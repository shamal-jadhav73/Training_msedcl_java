package com.msedcl.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.msedcl.main.domain.LoginDetails;
import com.msedcl.main.repository.LoginRepository;




@Service
public class LoginService {

	
	private LoginRepository loginRepository;

	
	
	public LoginService(LoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
		System.out.println("OVERLOADED CONSTRUCTOR called-LOGIN SERVICE");
	}
	public LoginRepository getLoginRepository() {
		System.out.println("getLoginRepository()");
		return loginRepository;
	}
	
	
	public void setLoginRepository(LoginRepository loginRepository) {
		System.out.println("setLoginRepository()");
		this.loginRepository = loginRepository;
		
	}
	public boolean validate(LoginDetails loginDetails)
	{
		return loginRepository.validateLoginDetails(loginDetails);
	}
	
	public boolean addNewUser(LoginDetails loginDetails)
	{
		return loginRepository.addNewUser(loginDetails);
	}
}