package com.msedcl.main.service;

import org.springframework.stereotype.Service;

@Service
public class BillingService {
public BillingService() {
	// TODO Auto-generated constructor stub
	
	System.out.println("----Default Constructor of billing Service Called------");
}


public double calculateBill()
{
	
	return 100.23;
}
}
