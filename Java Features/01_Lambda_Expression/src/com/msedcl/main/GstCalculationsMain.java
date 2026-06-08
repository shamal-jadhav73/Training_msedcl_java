package com.msedcl.main;

import com.msedcl.main.domain.GstCalculation;

public class GstCalculationsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printBill((x)->
			(x*8)*0.18,20);

	}

	
	public static void printBill(GstCalculation gstCalculation,int units)
	{
		System.out.println("Total Units :"+units);
		System.out.println("Gst Amount:"+gstCalculation.calculate(units));
		double finalBill=units*8+gstCalculation.calculate(units);
		System.out.println("Final Bill is:"+finalBill);
		
	}
}
