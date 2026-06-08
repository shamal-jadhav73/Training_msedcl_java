package com.msedcl.main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.msedcl.main.domain.Condition;
import com.msedcl.main.domain.Person;
import com.msedcl.main.domain.SortByLastName;

public class PersonMainLambda {
	public static void main(String[] args) {

		// Creating Person Class Objects
		Person person1 = new Person("Vivek", "Gohil", 36);
		Person person2 = new Person("Trupti", "Acharekar", 38);
		Person person3 = new Person("Samarth", "Patil", 10);
		Person person4 = new Person("Gurubux", "Gill", 30);

		// Storing person objects into List
		List<Person> people = Arrays.asList(person1, person2, person3, person4);

		// Printing all Persons of list

		/*
		 * for (Person person : people) {
		 * 
		 * System.out.println(person);
		 * 
		 * }
		 */

		// 1.Sort this list by last name
		// With Lambda Expression

		// Comparator<Person>
		// sortByLastName=(p1,p2)->p1.getLastName().compareTo(p2.getLastName());
		// people.sort(sortByLastName);

		System.out.println("..PRINTING ALL PERSONS  USING LAMBDA EXPRESSION..");

		printConditionally(people, (p) -> true, (p) -> System.out.println(p));

		// printList(people);
		System.out.println("..PRINTING SORTED PERSONS LUSING LAMBDA EXPRESSION..");
		// using most compact form
		people.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		printConditionally(people, (p) -> true, (p) -> System.out.println(p));

		// 2.PRINTING PERSONS LASTNAME STARTING WITH G USING LAMBDA EXPRESSION
		System.out.println("..PRINTING PERSONS LASTNAME STARTING WITH G USING LAMBDA EXPRESSION..");

		printConditionally(people, (p) -> p.getLastName().startsWith("G"), (p) -> System.out.println(p.getLastName()));

		System.out.println("..PRINTING PERSONS LASTNAME ENDING WITH l USING LAMBDA EXPRESSION..");

		printConditionally(people, (p) -> p.getLastName().endsWith("l"),
				(p) -> System.out.println(p.getFirstName() + " " + p.getLastName()));

	}

	public static void printList(List<Person> list) {
		for (Person person : list) {
			System.out.println(person);

		}
	}

	public static void printConditionally(List<Person> list, Predicate<Person> condition, Consumer<Person> consumer) {
		for (Person person : list) {
			if (condition.test(person))
				consumer.accept(person);
			;

		}
	}

}
