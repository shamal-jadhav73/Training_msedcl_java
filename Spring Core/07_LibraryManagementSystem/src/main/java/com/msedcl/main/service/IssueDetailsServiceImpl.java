package com.msedcl.main.service;

import org.springframework.stereotype.Service;

import com.msedcl.main.entity.IssueDetails;
import com.msedcl.main.repository.IssueDetailsRepository;
@Service
public class IssueDetailsServiceImpl implements IssueDetailsService {
	
	IssueDetailsRepository issueDetailsRepository;
	

	public IssueDetailsServiceImpl(IssueDetailsRepository issueDetailsRepository) {
		super();
		this.issueDetailsRepository = issueDetailsRepository;
	}

	@Override
	public IssueDetails issueBook(IssueDetails issueDetails) {
		// TODO Auto-generated method stub
		return issueDetailsRepository.issueBook(issueDetails);
	}

	@Override
	public IssueDetails returnBook(IssueDetails issueDetails) {
		// TODO Auto-generated method stub
		return issueDetailsRepository.returnBook(issueDetails);
	}

	@Override
	public IssueDetails getIssuedBookByIssueId(int issueId) {
		// TODO Auto-generated method stub
		return issueDetailsRepository.getIssuedBookByIssueId(issueId);
	}

	@Override
	public IssueDetails getIssuedBookByMemberCode(int memberCode) {
		// TODO Auto-generated method stub
		return issueDetailsRepository.getIssuedBookByMemberCode(memberCode);
	}

	@Override
	public IssueDetails getIssuedBookByBookCode(int bookCode) {
		// TODO Auto-generated method stub
		return issueDetailsRepository.getIssuedBookByBookCode(bookCode);
	}

}
