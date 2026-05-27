package com.msedcl.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="login_details")
public class LoginDetails {
	@Override
	public String toString() {
		return "LoginDetails [loginID=" + loginID + ", password=" + password + ", invalidLoginCount="
				+ invalidLoginCount + ", max=" + max + ", Status=" + Status + "]";
	}

	@Id
	@Column(name = "login_id")
	int loginID;
	@Column(name = "password")
	String password;
	@Column(name = "invalid_login_count")
	int invalidLoginCount;
	@Column(name = "max")
	int max;
	@Column(name = "status")
	String Status;
	
public LoginDetails() {
	// TODO Auto-generated constructor stub
}

public LoginDetails(int loginID, String password, String status) {
	super();
	this.loginID = loginID;
	this.password = password;
	Status = status;
}

public int getLoginID() {
	return loginID;
}

public void setLoginID(int loginID) {
	this.loginID = loginID;
}

public String getPassword() {
	return password;
}

public void setInvalidLoginCount(int invalidLoginCount) {
	this.invalidLoginCount = invalidLoginCount;
}

public void setMax(int max) {
	this.max = max;
}

public void setPassword(String password) {
	this.password = password;
}

public String getStatus() {
	return Status;
}

public void setStatus(String status) {
	Status = status;
}

public int getInvalidLoginCount() {
	return invalidLoginCount;
}

public int getMax() {
	return max;
}

}
