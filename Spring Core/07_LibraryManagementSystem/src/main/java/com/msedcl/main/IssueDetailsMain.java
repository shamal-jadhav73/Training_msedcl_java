package com.msedcl.main;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.entity.Book;
import com.msedcl.main.entity.IssueDetails;
import com.msedcl.main.service.BookService;
import com.msedcl.main.service.BookServiceImpl;
import com.msedcl.main.service.IssueDetailsService;
import com.msedcl.main.service.IssueDetailsServiceImpl;

public class IssueDetailsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.msedcl.main");
		
		IssueDetailsService issueDetailsService=applicationContext.getBean(IssueDetailsServiceImpl.class);
		Scanner scanner = new Scanner(System.in);
		int memberId, choice,bookId;
		String name, continueChoice,mtype,author,status;
		

		do {
			System.out.println("Menu");
			System.out.println("1.Issue Book");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			
			
			
			case 1:
				System.out.println("Enter Book Id:");
				bookId = scanner.nextInt();
				System.out.println("Enter Member Id:");
				memberId= scanner.nextInt();
				 // Current system date
			    LocalDate bookIssuedDate = LocalDate.now();
			    Date issueDate = java.sql.Date.valueOf(bookIssuedDate);
			    
			    // System date + 7 days
			    LocalDate returnDate = bookIssuedDate.plusDays(7);
			    Date dueDate = java.sql.Date.valueOf(returnDate);
				IssueDetails issueDetails = new IssueDetails(0, bookId, memberId,issueDate,dueDate);
				if (issueDetailsService.issueBook(issueDetails)!=null) {
					System.out.println("Book Issued Successfully");
					
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


