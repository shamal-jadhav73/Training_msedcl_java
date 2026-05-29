package com.msedcl.main.entity;

public class MemberType {
	private int memberTypeId;
	private String memberType;
	private int maxAllowedCount;
	
public MemberType() {
	// TODO Auto-generated constructor stub
}

public int getMemberTypeId() {
	return memberTypeId;
}

public void setMemberTypeId(int memberTypeId) {
	this.memberTypeId = memberTypeId;
}

public String getMemberType() {
	return memberType;
}

@Override
public String toString() {
	return "MemberType [memberTypeId=" + memberTypeId + ", memberType=" + memberType + ", maxAllowedCount="
			+ maxAllowedCount + "]";
}

public MemberType(int memberTypeId, String memberType, int maxAllowedCount) {
	super();
	this.memberTypeId = memberTypeId;
	this.memberType = memberType;
	this.maxAllowedCount = maxAllowedCount;
}

public void setMemberType(String memberType) {
	this.memberType = memberType;
}

public int getMaxAllowedCount() {
	return maxAllowedCount;
}

public void setMaxAllowedCount(int maxAllowedCount) {
	this.maxAllowedCount = maxAllowedCount;
}
}
