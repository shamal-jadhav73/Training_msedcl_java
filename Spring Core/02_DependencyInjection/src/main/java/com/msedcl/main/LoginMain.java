package com.msedcl.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.domain.LoginDetails;
import com.msedcl.main.service.LoginService;

public class LoginMain {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				"com.msedcl.main");
		boolean status;
		System.out.println("--------------------------------------------------");

		// 1. Add 3 users into database
		LoginDetails user1 = new LoginDetails("ADMIN", "Admin@123");
		LoginDetails user2 = new LoginDetails("USER", "User@123");
		LoginDetails user3 = new LoginDetails("POWERUSER", "PowerUser@123");

		// Inject LoginService object from Spring
		LoginService loginService = applicationContext.getBean(LoginService.class);

		System.out.println("Adding First User");
		status = loginService.addNewUser(user1);
		System.out.println("Status = " + status);
		System.out.println();
		System.out.println("Adding Second User");
		status = loginService.addNewUser(user2);
		System.out.println("Status = " + status);
		System.out.println();
		System.out.println("Adding Third User");
		status = loginService.addNewUser(user3);
		System.out.println("Status = " + status);
		System.out.println();
		
		// 2. Validate only single user

	}
}