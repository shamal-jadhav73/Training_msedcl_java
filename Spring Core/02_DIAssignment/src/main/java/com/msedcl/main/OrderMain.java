package com.msedcl.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.msedcl.main.service.OrderService;

public class OrderMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				"com.msedcl.main");
		OrderService orderService = applicationContext.getBean(OrderService.class);
		
		System.out.println("Your Bill is:"+orderService.calculateBill());

	}

	
	
}
