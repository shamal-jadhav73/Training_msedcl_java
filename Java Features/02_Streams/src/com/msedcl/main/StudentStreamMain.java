package com.msedcl.main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.domain.msedcl.main.Student;

public class StudentStreamMain {

	public static void main(String[] args) {
		List<Student> studentList = Stream.of(
				new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122,
						Arrays.asList("+912632632782", "+1673434729929")),
				new Student(2, "Pulkit", 56, "Male", "Computer Engineering", "Delhi", 67,
						Arrays.asList("+912632632762", "+1673434723929")),
				new Student(3, "Ankit", 25, "Female", "Mechanical Engineering", "Kerala", 164,
						Arrays.asList("+912632633882", "+1673434709929")),
				new Student(4, "Satish Ray", 30, "Male", "Mechanical Engineering", "Kerala", 26,
						Arrays.asList("+9126325832782", "+1671434729929")),
				new Student(5, "Roshan", 23, "Male", "Biotech Engineering", "Mumbai", 12,
						Arrays.asList("+012632632782")),
				new Student(6, "Chetan", 24, "Male", "Mechanical Engineering", "Karnataka", 90,
						Arrays.asList("+9126254632782", "+16736784729929")),
				new Student(7, "Arun", 26, "Male", "Electronics Engineering", "Karnataka", 324,
						Arrays.asList("+912632632782", "+1671234729929")),
				new Student(8, "Nam", 31, "Male", "Computer Engineering", "Karnataka", 433,
						Arrays.asList("+9126326355782", "+1673434729929")),
				new Student(9, "Sonu", 27, "Female", "Computer Engineering", "Karnataka", 7,
						Arrays.asList("+9126398932782", "+16563434729929", "+5673434729929")),
				new Student(10, "Shubham", 26, "Male", "Instrumentation Engineering", "Mumbai", 98,
						Arrays.asList("+912632646482", "+16734323229929")))
				.collect(Collectors.toList());

		System.out.println(studentList);
		System.out.println();
		System.out.println();
		studentList.forEach(s -> System.out.println(s));
		System.out.println();
		System.out.println();
		System.out.println();
// 1. Find the List of student whose rank is between 50 to 100
		System.out.println("1. Find the List of student whose rank is between 50 to 100");
		List<Student> filteredList = studentList.stream().filter((s) -> (s.getRank() >= 50 && s.getRank() <= 100))
				.collect(Collectors.toList());
		System.out.println("-----------Solution for student with id between 50 and 100----------------");
		filteredList.forEach(s -> System.out.println(s));
		System.out.println();
		System.out.println();
		System.out.println();
// 2. Find the students whose stays in Karnataka and sort them by their names
		System.out.println("2.Find the students whose stays in Karnataka and sort them by their names");
		System.out.println();
		filteredList = studentList.stream().filter(s -> s.getCity().equalsIgnoreCase("Karnataka"))
				.sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName())).collect(Collectors.toList());
		filteredList.forEach(s -> System.out.println(s));
		System.out.println();
		System.out.println();
		System.out.println();

// 3. Find all the departments names
		System.out.println("3.Find all the departments names");
		System.out.println();
		List<String> departmentNames = studentList.stream().map(s -> s.getDept()).distinct()
				.collect(Collectors.toList());
		departmentNames.forEach(d -> System.out.println(d));
		System.out.println();
		System.out.println();
		System.out.println();

// 4. Find all the contact number
		System.out.println("4. Find all the contact number");
		System.out.println();
		List<List<String>> contactNumbers = studentList.stream().map(s -> s.getContacts()).collect(Collectors.toList());

		contactNumbers.forEach(c -> System.out.println(c));
		System.out.println();
		System.out.println();
		System.out.println();
// 5. Group the student by the department names

		System.out.println("5. Group the student by the department names");
		System.out.println();
		Map<String, List<Student>> groupByDepartment = studentList.stream()
				.collect(Collectors.groupingBy(s -> s.getDept()));
		groupByDepartment.forEach((d, s) -> {
			System.out.println("---------Department-----=>" + d+"<=------------------------------");
			s.forEach(l -> System.out.println(l));

		});
		System.out.println();
		System.out.println();
		System.out.println();
// 6. Find the average age of male and female student
		System.out.println("6. Find the average age of male and female student");
		System.out.println();
		Map<String, Double> groupByGender = studentList.stream()
				.collect(Collectors.groupingBy(s -> s.getGender(), Collectors.averagingDouble(s -> s.getAge())));

		groupByGender.forEach((gender, age) -> {
			System.out.println("Gender=>" + gender + "Average Age=>" + age);
		});
		System.out.println();
		System.out.println();
		System.out.println();
// 7. Find the highest rank in each department
		System.out.println(" 7. Find the highest rank in each department");
		System.out.println();
		
		Map<String,Optional<Student>> highestRankByDepartment=studentList.stream().collect(Collectors.groupingBy(s->s.getDept(),Collectors.minBy((s1,s2)->s1.getRank()-s2.getRank())));

		highestRankByDepartment.forEach((department, optionalStudent) -> {
			System.out.println("---------Department-----=>" + department+"<=------------------------------");
			
               if(optionalStudent.isPresent())
            	   System.out.println(optionalStudent.get());
		});
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println(" 8. Find the student who has the second rank");
		System.out.println();
		
// 8. Find the student who has the second rank
		
		
		System.out.println(studentList.stream().sorted((s1,s2)->s1.getRank()-s2.getRank()).skip(1).findFirst().get());

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Using var variable data type");
		var student=studentList.stream().sorted((s1,s2)->s1.getRank()-s2.getRank()).skip(1).findFirst().get();
		
		System.out.println(student);
	}

}
