package com.msedcl.main.service;

import com.msedcl.main.entity.IssueDetails;

public interface IssueDetailsService {
	
	IssueDetails issueBook(IssueDetails issueDetails);
	IssueDetails returnBook(IssueDetails issueDetails);
	IssueDetails getIssuedBookByIssueId(int issueId);
	IssueDetails getIssuedBookByMemberCode(int memberCode);
	IssueDetails getIssuedBookByBookCode(int bookCode);

}
