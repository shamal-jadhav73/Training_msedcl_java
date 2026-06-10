package com.msedcl.main.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.msedcl.main.entity.Member;


@Repository
public class MemberRepositoryImpl implements MemberRepository {
	
	
	public MemberRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	private JdbcTemplate jdbcTemplate;

	private static final String ADD_NEW_MEMBER = "INSERT INTO member_details(member_name,member_type,issue_count) VALUES(?,?,?)";
	private static final String UPDATE_MEMBER = "UPDATE member_details SET member_name=?,member_type=? WHERE member_code=?";
	private static final String DELETE_MEMBER = "DELETE FROM member_details WHERE member_code=?";
	private static final String GET_MEMBER_BY_MEMBER_ID = "SELECT * from member_details WHERE member_code=?";
	private static final String GET_ALL_MEMBERS = "SELECT * from member_details";
	private static final String GET_COUNT_OF_MEMBER = "SELECT COUNT(*) from member_details";

	@Override
	public Member addNewMember(Member member) {
		// TODO Auto-generated method stub
		
		
		int rowsInserted = jdbcTemplate.update(ADD_NEW_MEMBER, member.getMemberName(), member.getMemberType(),member.getIssueCount());
		
		System.out.println("Rows Inserted:rowsInserted"+rowsInserted);

		if (rowsInserted > 0)
			return member;
		else
			return null;
		
	}

	@Override
	public Member updateMember(Member member) {
		int rowsUpdated = jdbcTemplate.update(UPDATE_MEMBER, member.getMemberName(), member.getMemberType());
		if (rowsUpdated > 0)
			return member;
		else
			return null;
	}

	@Override
	public boolean deleteMember(int memberCode) {
		int rowsDeleted = jdbcTemplate.update(DELETE_MEMBER, memberCode);
		if (rowsDeleted > 0)
			return true;
		else
			return false;
	}

	@Override
	public Member getMember(int memberCode) {
		return jdbcTemplate.queryForObject(GET_MEMBER_BY_MEMBER_ID, (rs,row)->new Member(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)), memberCode);
	}

	@Override
	public List<Member> getAllMember() {
		return jdbcTemplate.query(GET_ALL_MEMBERS, (rs,row)->new Member(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
	}

	@Override
	public long getCountOfMember() {
		// TODO Auto-generated method stub
		return 0;
	}

}
