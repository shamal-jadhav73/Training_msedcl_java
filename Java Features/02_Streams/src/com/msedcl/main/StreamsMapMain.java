package com.msedcl.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.domain.msedcl.main.Person;

public class StreamsMapMain {

	public static void main(String[] args) {

		List<String> alphabets = Arrays.asList("a", "b", "c", "d", "e");
		System.out.println("Alphabests Entered:" + alphabets);
		// convert this alphabets into upper Case and add it into new list without using
		// lambda and streams
		List<String> Capitalised = new ArrayList<>();

		for (String a : alphabets) {
			Capitalised.add(a.toUpperCase());
		}

		System.out.println(Capitalised);

		System.out.println("-".repeat(80));
		System.out.println("-----With Lambda------");
		Capitalised = alphabets.stream().map(new Function<String, String>() {

			@Override
			public String apply(String t) {
				// TODO Auto-generated method stub
				return t.toUpperCase();
			}
		}).collect(Collectors.toList());

		Capitalised.forEach(s -> System.out.println(s));

		System.out.println("-".repeat(80));
		System.out.println("-----With Shortest Lambda------");

		Capitalised.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
		Capitalised.forEach(s -> System.out.println(s));

		// Create new list of person with uppercase firstname and last name and print
		// new list

		System.out.println("-".repeat(80));
		System.out.println("-----Create new list of person with uppercase firstname and last name and print------");

		// Creating Person Class Objects
		Person person1 = new Person("Vivek", "Gohil", 36);
		Person person2 = new Person("Trupti", "Acharekar", 38);
		Person person3 = new Person("Samarth", "Patil", 10);
		Person person4 = new Person("Gurubux", "Gill", 30);

		// Storing person objects into List
		List<Person> people = Arrays.asList(person1, person2, person3, person4);
		List<Person> people2;
		people2 = people.stream().map(s -> {
			s.setFirstName(s.getFirstName().toUpperCase());
			s.setLastName(s.getLastName().toUpperCase());
			return s;
		}).collect(Collectors.toList());
		
		people2.forEach(p->System.out.println(p));

	}

}
