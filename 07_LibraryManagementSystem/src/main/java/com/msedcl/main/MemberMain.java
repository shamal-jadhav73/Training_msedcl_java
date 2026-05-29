package com.msedcl.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.msedcl.main.entity.Member;
import com.msedcl.main.service.MemberServiceImpl;
import com.msedcl.main.service.MemberService;

public class MemberMain {
	public static void main(String[] args) {
	AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.msedcl.main");
	
	MemberService memberService=applicationContext.getBean(MemberServiceImpl.class);
	Scanner scanner = new Scanner(System.in);
	int memberId, choice;
	String name, continueChoice,mtype;
	

	do {
		System.out.println("Menu");
		System.out.println("1. Add New Member");
		System.out.println("2. List All Member");
		System.out.println("Enter your choice");
		choice = scanner.nextInt();
		switch (choice) {
		
		
		case 2:
			List<Member> memberList = memberService.getAllMember();
			memberList.forEach(e -> System.out.println(e));
			break;

		case 1:
			System.out.println("Enter Member Name:");
			name = scanner.next();
			System.out.println("Enter Member Type:");
			mtype = scanner.next();
			Member member = new Member(0, name, mtype,0);
			if (memberService.addNewMember(member)!=null) {
				System.out.println("New Member added successfully");
				
			}
			break;
		
		default:
			System.out.println("Invalid Choice");
			break;
		}
		System.out.println("Do you want to continue?");
		continueChoice = scanner.next();
	} while (continueChoice.equals("yes"));

	applicationContext.close();
	scanner.close();


}
}
