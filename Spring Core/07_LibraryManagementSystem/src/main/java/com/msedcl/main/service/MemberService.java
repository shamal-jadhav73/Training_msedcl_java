package com.msedcl.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.entity.Member;

public interface MemberService {
	 //Add new member
	Member addNewMember(Member member);
	//update member
	Member updateMember(Member member);
	//delete member by memberid
	boolean deleteMember(int memberCode);
	//select single member
	Member getMember(int memberCode);
	//list of all members
	List<Member> getAllMember();
	long getCountOfMember();
}
