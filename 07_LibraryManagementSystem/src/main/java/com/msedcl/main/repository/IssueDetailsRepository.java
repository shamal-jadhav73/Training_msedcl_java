package com.msedcl.main.repository;

import com.msedcl.main.entity.IssueDetails;

public interface IssueDetailsRepository {
	IssueDetails issueBook(IssueDetails issueDetails);
	IssueDetails returnBook(IssueDetails issueDetails);
	IssueDetails getIssuedBookByIssueId(int issueId);
	IssueDetails getIssuedBookByMemberCode(int memberCode);
	IssueDetails getIssuedBookByBookCode(int bookCode);
	

}
