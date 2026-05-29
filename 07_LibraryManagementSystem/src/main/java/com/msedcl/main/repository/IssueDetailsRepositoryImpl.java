package com.msedcl.main.repository;

import java.time.LocalDate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.msedcl.main.entity.Book;
import com.msedcl.main.entity.IssueDetails;
import com.msedcl.main.entity.Member;
import com.msedcl.main.entity.MemberType;
import com.msedcl.main.service.BookService;
import com.msedcl.main.service.MemberService;
@Repository
public class IssueDetailsRepositoryImpl implements IssueDetailsRepository {
	
	
private JdbcTemplate jdbcTemplate;
MemberService memberService;
BookService bookService;

private static final String UPDATE_ISSUE_DETAILS = "INSERT INTO issue_details(book_code,member_code,issue_date,due_date) VALUES(?,?,?,?)";
private static final String UPDATE_BOOK_DETAILS = "UPDATE TABLE BOOK_DETAILS SET availability_status=FALSE WHERE BOOK_CODE=?";
private static final String UPDATE_MEMBER_DETAILS = "UPDATE TABLE MEMBER_DETAILS SET ISSUE_COUNT=? WHERE MEMBER_CODE=?";
	
	public IssueDetailsRepositoryImpl(JdbcTemplate jdbcTemplate) {
	super();
	this.jdbcTemplate = jdbcTemplate;
}


	@Override
	public IssueDetails issueBook(IssueDetails issueDetails) {
		// TODO Auto-generated method stub
		Book book=bookService.getBookByBookId(issueDetails.getBookCode());
		Member member=memberService.getMember(issueDetails.getBookCode());
		MemberType memberType = new MemberType();
		//first we will validate member
		if(!validateMember(issueDetails.getMemberCode()))
		{
			System.out.println("Invalid Member Code");
			return null;
			
		}
		
		if(!validateBook(issueDetails.getBookCode()))
		{
			System.out.println("Invalid Book Code");
			return null;
			
		}
		
		if(!book.isAvailabilityStatus())
		{
			System.out.println("Book is not available");
			return null;
		}
		if(!book.getIssueableStatus().equalsIgnoreCase("Issuable"))
		{
			System.out.println("Book can not be issued.(reference book can not be issued");
			return null;
		}
		
		if(member.getMemberType().equalsIgnoreCase("Student")&&member.getIssueCount()>=3)
		{
			System.out.println("Student Book issue limit exceeded");
			return null;
		}
		
		if(member.getMemberType().equalsIgnoreCase("Teacher")&&member.getIssueCount()>=25)
		{
			System.out.println("Teacher Book issue limit exceeded");
			return null;
		}
		
		issuedBook(issueDetails.getMemberCode(),issueDetails.getBookCode());
		
		
		return null;
	}

	private void issuedBook(int memberCode, int bookCode)
	{
		Member member=memberService.getMember(memberCode);
	   LocalDate issueDate=LocalDate.now();
	   LocalDate dueDate=LocalDate.now();
	   if(member.getMemberType().equalsIgnoreCase("Student"))
	   {
	   dueDate=LocalDate.now().plusDays(10);
	   }
	   if(member.getMemberType().equalsIgnoreCase("Teacher"))
	   {
	   dueDate=LocalDate.now().plusMonths(3);
	   }
		
	   int rowsInserted = jdbcTemplate.update(UPDATE_ISSUE_DETAILS,memberCode,bookCode,issueDate,dueDate);
		
	   updateMemberIssueCount(memberCode);
	   updateBookAvailabilty(bookCode);
	}


	private void updateBookAvailabilty(int bookCode) {
		// TODO Auto-generated method stub
		 int rowsInserted = jdbcTemplate.update(UPDATE_BOOK_DETAILS,false,bookCode);
	}


	private void updateMemberIssueCount(int memberCode) {
		// TODO Auto-generated method stub
		
		
	}


	private boolean validateMember(int memberCode) {
		Member member=memberService.getMember(memberCode);
		if(member==null)
		{
			return false;
		}
		
		return true;
	}
	
	
	private boolean validateBook(int bookCode) {
		Book book=bookService.getBookByBookId(bookCode);
		if(book==null)
		{
			return false;
		}
		
		return true;
	}


	@Override
	public IssueDetails returnBook(IssueDetails issueDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IssueDetails getIssuedBookByIssueId(int issueId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IssueDetails getIssuedBookByMemberCode(int memberCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IssueDetails getIssuedBookByBookCode(int bookCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
