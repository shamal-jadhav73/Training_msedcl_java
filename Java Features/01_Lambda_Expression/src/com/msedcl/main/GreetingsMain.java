
package com.msedcl.main;

import com.msedcl.main.domain.GoodAfternoon;
import com.msedcl.main.domain.GoodEvening;
import com.msedcl.main.domain.GoodMorning;
import com.msedcl.main.domain.Greetings;

public class GreetingsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Greetings greetings=null;
		greetings = new GoodMorning();
		greetings.greet();
		
		greetings = new GoodAfternoon();
		greetings.greet();
		
		greetings = new GoodEvening();
		greetings.greet();

		 greetings = ()->System.out.println("Good Night All Using Lambda");
		 greetings.greet();

	}

}
