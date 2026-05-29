package com.msedcl.main.entity;

public class Book {

	private int bookCode;
	private String Title;
	private String Author;
	private String issueableStatus;
	private boolean availabilityStatus;
	public Book() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", Title=" + Title + ", Author=" + Author + ", issueableStatus="
				+ issueableStatus + ", availabilityStatus=" + availabilityStatus + "]";
	}
	public Book(int bookCode, String title, String author, String issueableStatus, boolean availabilityStatus) {
		super();
		this.bookCode = bookCode;
		Title = title;
		Author = author;
		this.issueableStatus = issueableStatus;
		this.availabilityStatus = availabilityStatus;
	}
	public int getBookCode() {
		return bookCode;
	}
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getIssueableStatus() {
		return issueableStatus;
	}
	public void setIssueableStatus(String issueableStatus) {
		this.issueableStatus = issueableStatus;
	}
	public boolean isAvailabilityStatus() {
		return availabilityStatus;
	}
	public void setAvailabilityStatus(boolean availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
}
