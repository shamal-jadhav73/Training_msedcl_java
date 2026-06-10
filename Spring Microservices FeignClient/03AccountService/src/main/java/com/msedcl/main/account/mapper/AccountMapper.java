package com.msedcl.main.account.mapper;

import com.msedcl.main.account.dto.AccountRequestDTO;
import com.msedcl.main.account.dto.AccountResponseDTO;
import com.msedcl.main.account.dto.CustomerResponseDTO;
import com.msedcl.main.account.entity.Account;

public class AccountMapper {

	
	public static Account toEntity(AccountRequestDTO accountRequestDTO)
	{
		Account account = new Account();
		account.setCustomerId(accountRequestDTO.getCustomerId());
		account.setAccountType(accountRequestDTO.getAccountType());
		
		
		return account;
		
	}
	
	public static AccountResponseDTO toDTO(Account account,CustomerResponseDTO customerResponseDTO)
	{
		AccountResponseDTO accountResponseDTO=new AccountResponseDTO();
		accountResponseDTO.setAccountId(account.getAccountId());
		accountResponseDTO.setAccountType(account.getAccountType());
		accountResponseDTO.setBalance(account.getBalance());
		accountResponseDTO.setCustomerResponseDTO(customerResponseDTO);
		
		
		
		return accountResponseDTO;
	}
	
}
