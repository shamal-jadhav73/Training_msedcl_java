package com.msedcl.main.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceUpdateRequestDTO {
	private int accountId;
	double amount;
	String transactionType;
	

}
