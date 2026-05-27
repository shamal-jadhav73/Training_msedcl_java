package com.msedcl.main.domain;

public class LastNameStartWithG implements Condition{

	@Override
	public boolean test(Person person) {
		if(person.getLastName().startsWith("G"))
		return true;
		else
		return false;
	}
	

}
