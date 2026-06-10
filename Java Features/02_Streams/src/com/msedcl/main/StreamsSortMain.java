package com.msedcl.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.domain.msedcl.main.Person;

public class StreamsSortMain {

	public static void main(String[] args) {
		
		List<String> list= Arrays.asList("9","A","X","1","B","4","a","c");
		System.out.println(list);
		//sorting without lambda expression and streams
		System.out.println("sorting without lambda expression and streams");
		Collections.sort(list);
		System.out.println(list);
		
		//Option 1- Collect into new list
		System.out.println("Option 1- Sort and  Collect into new list");
		List<String> sortedListOne=list.stream().sorted().collect(Collectors.toList());
		 sortedListOne.forEach(c->System.out.println(c));
		 
		 //option 2-Using comparator sort and collect into a new list
		 System.out.println("option 2-Using comparator sort and collect into a new list");
		 List<String> sortedListTwo=list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		 sortedListTwo.forEach(c->System.out.println(c));
		 
		 //option 3-Sort and collect into a new list
		 System.out.println("option 3-Sort and collect into a new list");
		 List<String> sortedListThree=list.stream().sorted((s1,s2)->s1.compareTo(s2)).collect(Collectors.toList());
		 sortedListThree.forEach(c->System.out.println(c));
		 
		 //option 4:sort in reverse order
		 System.out.println("option 4:sort in reverse order");
		 List<String> sortedListFour=list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		 sortedListFour.forEach(c->System.out.println(c));
		
		
		 
		 //create list of person class
		 List<Person> people=Arrays.asList(new Person("Vivek", "Gohil", 36),new Person("Trupti", "Acharekar", 38),new Person("Samarth", "Patil", 10),new Person("Gurubux", "Gill", 30));

		 //sort by age and store in new list =>peopleSortedByAgeList
		 System.out.println("sort by age and store in new list =>peopleSortedByAgeList");
		 List<Person> peopleSortedByAgeList= people.stream().sorted((p1,p2)->p1.getAge()-p2.getAge()).collect(Collectors.toList());
		 peopleSortedByAgeList.forEach(p->System.out.println(p));
		 
		 //sort by first name and store it in a new list
		 System.out.println("sort by first name and store it in a new list");
		 List<Person> peopleSortedByFirstName= people.stream().sorted((p1,p2)->p1.getFirstName().compareTo(p2.getFirstName())).collect(Collectors.toList());
		 peopleSortedByFirstName.forEach(p->System.out.println(p));
		 
		 
		 
	}

}
