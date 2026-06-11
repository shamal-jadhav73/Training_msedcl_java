package com.msedcl.main.transaction.entity;

import java.sql.Date;
import java.time.LocalDateTime;

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
@Entity(name="transactions_details")
public class Transaction extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private int transactionId;
	
	@Column(name = "account_id", nullable = false)
	private int accountId;
	
	@Column(name = "transaction_type", nullable = false)
	private String transactionType;
	
	@Column(name = "amount", nullable = false)
	private double amount;
	
	@Column(name = "transaction_date")
	private LocalDateTime transactionDate;
}
