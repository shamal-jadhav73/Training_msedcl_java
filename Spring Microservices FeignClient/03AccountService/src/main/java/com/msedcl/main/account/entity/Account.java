package com.msedcl.main.account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "account_details")
public class Account extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int accountId;
	 
	@Column(name = "customer_id", nullable = false)
	private int customerId;
	
	@Column(name = "account_type",length=50, nullable = false)
	String accountType;
	 
	@Column(name = "balance")
	double balance;
}
