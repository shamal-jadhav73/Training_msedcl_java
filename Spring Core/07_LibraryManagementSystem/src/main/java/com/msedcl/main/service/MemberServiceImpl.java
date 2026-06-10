package com.msedcl.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.entity.Member;
import com.msedcl.main.repository.BookRepository;
import com.msedcl.main.repository.MemberRepository;
@Service
public class MemberServiceImpl implements MemberService {

	
	private  MemberRepository memberRepository;
	@Override
	public Member addNewMember(Member member) {
		// TODO Auto-generated method stub
		return memberRepository.addNewMember(member);
	}

	public MemberServiceImpl(MemberRepository memberRepository) {
		super();
		this.memberRepository = memberRepository;
	}

	@Override
	public Member updateMember(Member member) {
		// TODO Auto-generated method stub
		return memberRepository.updateMember(member);
	}

	@Override
	public boolean deleteMember(int memberCode) {
		// TODO Auto-generated method stub
		return memberRepository.deleteMember(memberCode);
	}

	@Override
	public Member getMember(int memberCode) {
		// TODO Auto-generated method stub
		return memberRepository.getMember(memberCode);
	}

	@Override
	public List<Member> getAllMember() {
		// TODO Auto-generated method stub
		return memberRepository.getAllMember();
	}

	@Override
	public long getCountOfMember() {
		// TODO Auto-generated method stub
		return memberRepository.getCountOfMember();
	}

}
