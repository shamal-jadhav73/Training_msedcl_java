package com.msedcl.main.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

	private BillingService billingService;

	public OrderService(BillingService billingService) {
		super();
		this.billingService = billingService;
		
		System.out.println("Parameterised constructor of OrderService Called");
	}
	
	public double calculateBill()
	{
		return billingService.calculateBill();
	}
	
	
}
