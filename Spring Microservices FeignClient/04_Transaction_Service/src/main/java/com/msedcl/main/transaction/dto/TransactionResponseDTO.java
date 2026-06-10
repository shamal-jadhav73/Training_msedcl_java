package com.msedcl.main.transaction.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponseDTO {
	private int transactionId;
	private AccountResponseDTO accountResponseDTO;
	private String transactionType;
	private double amount;
	private LocalDateTime transactionDate;
	
	

}
