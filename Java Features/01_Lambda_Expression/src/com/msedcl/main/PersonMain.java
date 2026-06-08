package com.msedcl.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.print.event.PrintJobAttributeListener;

import com.msedcl.main.domain.Condition;
import com.msedcl.main.domain.LastNameStartWithG;
import com.msedcl.main.domain.Person;
import com.msedcl.main.domain.SortByLastName;

public class PersonMain {

	public static void main(String[] args) {

		// Creating Person Class Objects
		Person person1 = new Person("Vivek", "Gohil", 36);
		Person person2 = new Person("Trupti", "Acharekar", 38);
		Person person3 = new Person("Samarth", "Patil", 10);
		Person person4 = new Person("Gurubux", "Gill", 30);

		// Storing person objects into List
		List<Person> people = Arrays.asList(person1, person2, person3, person4);

		// Printing all Persons of list

		for (Person person : people) {

			System.out.println(person);

		}

		// 1.Sort this list by last name
		// Without Lambda Expression
		SortByLastName byLastName = new SortByLastName();
		people.sort(byLastName);
		System.out.println("Done Sorting Based on Last Name");
		printList(people);
		
		System.out.println("Peoples Last Name Starting with G are:");
		Condition condition=new LastNameStartWithG();
		printStartWithG(people,condition);

		System.out.println("Peoples Last Name Ending with L are:");
		printEndWithL(people);

	}

	public static void printList(List<Person> list) {
		for (Person person : list) {
			System.out.println(person);

		}
	}
	
	
	public static void printStartWithG(List<Person> list,Condition condition)
	{
		for (Person person : list) {
			if(condition.test(person))
			System.out.println(person);

		}
	}

	
	public static void printEndWithL(List<Person> list)
	{
		for (Person person : list) {
			if(person.getLastName().endsWith("l"))
			System.out.println(person);

		}
	}
}
