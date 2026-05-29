package com.msedcl.main.service;

import java.util.List;

import com.msedcl.main.entity.Book;
import com.msedcl.main.entity.Member;

public interface BookService {
	
	 //Add new member
		Book addNewBook(Book book);
		//update member
		Book updatAvailabilityStatus(Book book);
		//delete member by memberid
		
		//select single member
		Book getBookByBookId(int bookCode);
		//list of all members
		List<Member> getAllBooks();
		long getCountOfBooks();

}
