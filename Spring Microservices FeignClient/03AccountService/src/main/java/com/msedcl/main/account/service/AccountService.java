package com.msedcl.main.account.service;

import java.util.List;

import com.msedcl.main.account.dto.AccountRequestDTO;
import com.msedcl.main.account.dto.AccountResponseDTO;
import com.msedcl.main.account.dto.BalanceUpdateRequestDTO;


public interface AccountService {

	AccountResponseDTO createNewAccount(AccountRequestDTO accountRequestDTO);
	AccountResponseDTO getAccountByAccountId(Integer accountId);
	List<AccountResponseDTO> getAccountByCustomertId(Integer customerId);
	AccountResponseDTO updateAccountBalance(BalanceUpdateRequestDTO balanceUpdateRequestDTO );
}
