package com.msedcl.main.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.msedcl.main.entity.Book;
import com.msedcl.main.entity.Member;


@Repository
public class BookRepositoryImpl implements BookRepository {

	
	public BookRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	private JdbcTemplate jdbcTemplate;
	
	
	private static final String ADD_NEW_BOOK = "INSERT INTO book_details(book_title,book_author,issuable_status,availability_status) VALUES(?,?,?,?)";
	private static final String UPDATE_BOOK = "UPDATE book_details SET availability_status=? WHERE book_code=?";
	private static final String GET_BOOK_BY_BOOK_ID = "SELECT * from book_details WHERE book_code=?";
	
	@Override
	public Book addNewBook(Book book) {
		System.out.println(book);
		int rowsInserted = jdbcTemplate.update(ADD_NEW_BOOK, book.getTitle(),book.getAuthor(),book.getIssueableStatus(),book.isAvailabilityStatus());

		if (rowsInserted > 0)
			return book;
		else
			return null;
	}

	@Override
	public Book updatAvailabilityStatus(Book book) {
		int rowsUpdated = jdbcTemplate.update(UPDATE_BOOK,book.isAvailabilityStatus());
		if (rowsUpdated > 0)
			return book;
		else
			return null;
	}

	@Override
	public Book getBookByBookId(int bookCode) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(GET_BOOK_BY_BOOK_ID, (rs,row)->new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5)), bookCode);
	}

	@Override
	public List<Member> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCountOfBooks() {
		// TODO Auto-generated method stub
		return 0;
	}

}
