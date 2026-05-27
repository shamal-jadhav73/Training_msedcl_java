package com.msedcl.main;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.domain.LoginDetails;
import com.msedcl.main.service.LoginService;

public class LoginMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter UserId:");
		String loginId = scanner.next();
		System.out.println("Enter Password:");
		String password = scanner.next();

		LoginDetails loginDetails = new LoginDetails(loginId, password);
		//LoginService loginService = new LoginService();
		//spring container
		//by following line Spring will go in package mentioned in double quotes
		//and check the classes named component and make its objects at this point
		//OBJECT MAKING FACTORY
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.msedcl.main.service");
		
		
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		//following code will return the object which was already made in previous line
		LoginService loginService=applicationContext.getBean(LoginService.class);
		System.out.println("-----------------------------------------------------");
		
		LoginService loginService2=applicationContext.getBean(LoginService.class);
		if (loginService.validateLoginDetails(loginDetails)) {
			System.out.println("Login Successfully");
		}

		else {
			System.out.println("Login failed.!");
		}

		scanner.close();

	}

}
