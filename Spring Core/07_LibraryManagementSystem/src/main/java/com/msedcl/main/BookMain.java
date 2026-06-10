package com.msedcl.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.entity.Book;
import com.msedcl.main.entity.Member;
import com.msedcl.main.service.BookServiceImpl;
import com.msedcl.main.service.BookService;
import com.msedcl.main.service.MemberService;
import com.msedcl.main.service.MemberServiceImpl;

public class BookMain {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.msedcl.main");
		
		BookService bookService=applicationContext.getBean(BookServiceImpl.class);
		Scanner scanner = new Scanner(System.in);
		int memberId, choice,bookId;
		String name, continueChoice,mtype,author,status;
		

		do {
			System.out.println("Menu");
			System.out.println("1. Add New Book");
			System.out.println("2. Get Book By BOOK ID");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			
			
			case 2:
				System.out.println("Enter Book Id:");
				bookId = scanner.nextInt();
				System.out.println(bookService.getBookByBookId(bookId));
				break;

			case 1:
				System.out.println("Enter Book Name:");
				name = scanner.next();
				System.out.println("Enter Author Name:");
				author = scanner.next();
				System.out.println("Enter Issuable Status:");
				status = scanner.next();
				Book book = new Book(0, name, author,status,true);
				if (bookService.addNewBook(book)!=null) {
					System.out.println("New Book added successfully");
					
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
