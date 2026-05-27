package com.msedcl.main.domain;

public class LoginDetails {
	private String loginId;
	private String password;
public LoginDetails() {
	// TODO Auto-generated constructor stub
}
public LoginDetails(String loginId, String password) {
	super();
	this.loginId = loginId;
	this.password = password;
}
public String getLoginId() {
	return loginId;
}
public void setLoginId(String loginId) {
	this.loginId = loginId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "LoginDetails [loginId=" + loginId + ", password=" + password + "]";
}
}
