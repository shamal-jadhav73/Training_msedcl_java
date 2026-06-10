package com.msedcl.main.domain;

import java.util.Comparator;

public class SortByLastName implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		// TODO Auto-generated method stub
		return p1.getLastName().compareTo(p2.getLastName());
	}

}
