package com.msedcl.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="address_details")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressId;
	
	
	@Column(name="city", length=50,nullable=false)
	private String city;
	
	@Column(name="pin_code", length=10,nullable=false)
	private String pinCode;

	
	
	
	
	public Address() {
	// TODO Auto-generated constructor stub
}
public int getAddressId() {
	return addressId;
}
public void setAddressId(int addressId) {
	this.addressId = addressId;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPinCode() {
	return pinCode;
}
public void setPinCode(String pinCode) {
	this.pinCode = pinCode;
}
public Address(int addressId, String city, String pinCode) {
	super();
	this.addressId = addressId;
	this.city = city;
	this.pinCode = pinCode;
}
@Override
public String toString() {
	return "Address [addressId=" + addressId + ", city=" + city + ", pinCode=" + pinCode + "]";
}
}
