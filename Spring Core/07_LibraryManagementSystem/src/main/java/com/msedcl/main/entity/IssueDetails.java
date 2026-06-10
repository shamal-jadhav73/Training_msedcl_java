package com.msedcl.main.entity;

import java.sql.Date;
import java.time.LocalDate;

public class IssueDetails {
	private int issueId;
	private int bookCode;
	private int memberCode;
	private Date issueDate;
	private Date dueDate;
	public IssueDetails() {
		// TODO Auto-generated constructor stub
	}
	public IssueDetails(int issueId, int bookCode, int memberCode, Date issueDate, Date dueDate) {
		super();
		this.issueId = issueId;
		this.bookCode = bookCode;
		this.memberCode = memberCode;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
	}
	
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public int getBookCode() {
		return bookCode;
	}
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public int getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "IssueDetails [issueId=" + issueId + ", bookCode=" + bookCode + ", memberCode=" + memberCode
				+ ", issueDate=" + issueDate + ", dueDate=" + dueDate + "]";
	}

}
