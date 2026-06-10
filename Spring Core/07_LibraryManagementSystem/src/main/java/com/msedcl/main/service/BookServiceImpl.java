package com.msedcl.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.entity.Book;
import com.msedcl.main.entity.Member;
import com.msedcl.main.repository.BookRepository;
import com.msedcl.main.repository.MemberRepository;
@Service
public class BookServiceImpl implements BookService {

	
	private  BookRepository bookRepository;
	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public Book addNewBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.addNewBook(book);
	}

	@Override
	public Book updatAvailabilityStatus(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.updatAvailabilityStatus(book);
	}

	@Override
	public Book getBookByBookId(int bookCode) {
		// TODO Auto-generated method stub
		return bookRepository.getBookByBookId(bookCode);
	}

	@Override
	public List<Member> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.getAllBooks();
	}

	@Override
	public long getCountOfBooks() {
		// TODO Auto-generated method stub
		return bookRepository.getCountOfBooks();
	}

}
