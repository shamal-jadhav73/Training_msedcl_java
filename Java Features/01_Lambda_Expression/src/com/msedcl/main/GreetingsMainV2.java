package com.msedcl.main;

import com.msedcl.main.domain.GoodAfternoon;
import com.msedcl.main.domain.GoodMorning;
import com.msedcl.main.domain.Greetings;

public class GreetingsMainV2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Greetings greetings=null;
		
		//first method to call method print message
		
		greetings =new GoodMorning();
		printMessage(greetings);
		
		//Without creating variable we can directly pass object of a class
		
		printMessage(new GoodAfternoon());
		
		//Using lambda Expression
		
	    printMessage(()->System.out.println("Have a good day"));

	}
	
	public static void printMessage(Greetings greetings)
	{
		greetings.greet();
	}

}
