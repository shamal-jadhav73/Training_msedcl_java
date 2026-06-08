package com.msedcl.main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.domain.msedcl.main.Person;

public class StramsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> names = Arrays.asList("Vivek", "Bahubali", "Trupti", "Samarth");
		// Without using streams
		for (String name : names) {
			if (!name.equals("Bahubali")) {
				System.out.println(name);
			}

		}

		System.out.println("Using Streams");
		// USING STREAMS
		names.stream().filter((name) -> !name.equals("Bahubali")).forEach((name) -> System.out.println(name));
		
		System.out.println();
		//storing filtered list into a collection filtered
		
		 List<String> filtered=names.stream().filter(name->!name.equals("Bahubali")).collect(Collectors.toList());
		 
		 filtered.forEach(n->System.out.println(n));

		// Creating Person Class Objects
		Person person1 = new Person("Vivek", "Gohil", 36);
		Person person2 = new Person("Trupti", "Acharekar", 38);
		Person person3 = new Person("Samarth", "Patil", 10);
		Person person4 = new Person("Gurubux", "Gill", 30);

		// Storing person objects into List
		List<Person> people = Arrays.asList(person1, person2, person3, person4);

		// print first name and last name from above list except samarth

		people.stream().filter((p) -> !p.getFirstName().equals("Samarth"))
				.forEach((p) -> System.out.println(p.getFirstName() + " " + p.getLastName()));

	}

}
