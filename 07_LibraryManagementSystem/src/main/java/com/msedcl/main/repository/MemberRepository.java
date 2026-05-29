package com.msedcl.main.repository;

import java.util.List;

import com.msedcl.main.entity.Member;



public interface MemberRepository {

	
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
