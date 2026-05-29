package com.msedcl.main.entity;

public class Member {
	private int memberCode;
	private String memberName;
	private String memberType;
	private int issueCount;
public Member() {
	// TODO Auto-generated constructor stub
}
public Member(int memberCode, String memberName, String memberType, int issueCount) {
	super();
	this.memberCode = memberCode;
	this.memberName = memberName;
	this.memberType = memberType;
	this.issueCount = issueCount;
}
public int getMemberCode() {
	return memberCode;
}
public void setMemberCode(int memberCode) {
	this.memberCode = memberCode;
}
public String getMemberName() {
	return memberName;
}
public void setMemberName(String memberName) {
	this.memberName = memberName;
}
public String getMemberType() {
	return memberType;
}
public void setMemberType(String memberType) {
	this.memberType = memberType;
}
public int getIssueCount() {
	return issueCount;
}
public void setIssueCount(int issueCount) {
	this.issueCount = issueCount;
}
@Override
public String toString() {
	return "Member [memberCode=" + memberCode + ", memberName=" + memberName + ", memberType=" + memberType
			+ ", issueCount=" + issueCount + "]";
}
}
