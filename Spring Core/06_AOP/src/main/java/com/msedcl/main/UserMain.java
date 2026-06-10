package com.msedcl.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.configuration.SpringConfiguration;
import com.msedcl.main.service.UserService;

public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(".............Main Start..........");
        
        AnnotationConfigApplicationContext applicationContext= new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService=applicationContext.getBean(UserService.class);
        UserService userService2=applicationContext.getBean(UserService.class);
        userService.createUser("Reema");
        applicationContext.close();        
        System.out.println(".............Main End..........");
	}

}
