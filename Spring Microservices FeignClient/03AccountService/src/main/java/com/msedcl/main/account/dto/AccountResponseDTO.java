package com.msedcl.main.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AccountResponseDTO {
	private int accountId;
	CustomerResponseDTO customerResponseDTO;
	String accountType;
	private double balance;

}
