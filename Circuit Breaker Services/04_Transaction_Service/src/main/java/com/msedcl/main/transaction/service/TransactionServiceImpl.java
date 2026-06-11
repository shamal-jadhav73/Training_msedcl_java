package com.msedcl.main.transaction.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.msedcl.main.transaction.client.AccountFeignClient;
import com.msedcl.main.transaction.client.AccountRestClient;
import com.msedcl.main.transaction.dto.AccountResponseDTO;
import com.msedcl.main.transaction.dto.BalanceUpdateRequestDTO;
import com.msedcl.main.transaction.dto.TransactionRequestDTO;
import com.msedcl.main.transaction.dto.TransactionResponseDTO;
import com.msedcl.main.transaction.entity.Transaction;
import com.msedcl.main.transaction.exception.InsufficientBalanceException;
import com.msedcl.main.transaction.mapper.TransactionMapper;
import com.msedcl.main.transaction.repository.TransactionRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class TransactionServiceImpl implements TransactionService {

	private TransactionRepository transactionRepository;
	//commented below to add feign client instead of restClient
	
	//private AccountRestClient accountRestClient;
	private AccountFeignClient accountFeignClient;

	@Override
	public TransactionResponseDTO depositAmount(TransactionRequestDTO transactionRequestDTO) {
		AccountResponseDTO accountResponseDTO = accountFeignClient
				.getAccountByAccountId(transactionRequestDTO.getAccountId()).getBody().getData();

		// update balance (existing balance we get from accountResponse and amount ww
		// will get from transaction request

		double newBalance = accountResponseDTO.getBalance() + transactionRequestDTO.getAmount();

		// Prepare balance update request
		BalanceUpdateRequestDTO balanceRequestDTO = new BalanceUpdateRequestDTO();

		balanceRequestDTO.setAccountId(transactionRequestDTO.getAccountId());
		balanceRequestDTO.setAmount(transactionRequestDTO.getAmount());
		balanceRequestDTO.setTransactionType("DEPOSIT");

		// Call Account Service
		AccountResponseDTO updatedAccount = accountFeignClient.updateAccount(balanceRequestDTO).getBody().getData();

		// Create transaction entity
		Transaction transaction = new Transaction();
		transaction.setAccountId(transactionRequestDTO.getAccountId());
		transaction.setAmount(transactionRequestDTO.getAmount());
		transaction.setTransactionType("DEPOSIT");
		transaction.setTransactionDate(LocalDateTime.now());

		// Save transaction
		Transaction savedTransaction = transactionRepository.save(transaction);

		TransactionResponseDTO transactionResponseDTO = TransactionMapper.toDTO(savedTransaction, accountResponseDTO);

		return transactionResponseDTO;
	}

	@Override
	public TransactionResponseDTO withdrawAmount(TransactionRequestDTO transactionRequestDTO) {

		AccountResponseDTO accountResponseDTO = accountFeignClient
				.getAccountByAccountId(transactionRequestDTO.getAccountId()).getBody().getData();

		// balance condition
		if (accountResponseDTO.getBalance() < transactionRequestDTO.getAmount()) {
			throw new InsufficientBalanceException("Insufficient balance");
		}
		
		

		// 3. Prepare balance update request (NEGATIVE or direct subtraction handled in
		// account service)
		BalanceUpdateRequestDTO balanceRequestDTO = new BalanceUpdateRequestDTO();

		balanceRequestDTO.setAccountId(transactionRequestDTO.getAccountId());
		balanceRequestDTO.setAmount(transactionRequestDTO.getAmount());
		balanceRequestDTO.setTransactionType("WITHDRAW");
		
		// Call Account Service
		AccountResponseDTO updatedAccount = accountFeignClient.updateAccount(balanceRequestDTO).getBody().getData();

		// 5. Create transaction entity
		Transaction transaction = new Transaction();
		transaction.setAccountId(transactionRequestDTO.getAccountId());
		transaction.setAmount(transactionRequestDTO.getAmount());
		transaction.setTransactionType("WITHDRAW");
		transaction.setTransactionDate(LocalDateTime.now());

		Transaction savedTransaction = transactionRepository.save(transaction);

		TransactionResponseDTO transactionResponseDTO = TransactionMapper.toDTO(savedTransaction, accountResponseDTO);

		return transactionResponseDTO;
	}

	@Override
	public List<TransactionResponseDTO> getTransactionsByAccountId(int accountId) {

		AccountResponseDTO accountResponseDTO = accountFeignClient.getAccountByAccountId(accountId).getBody().getData();

		List<Transaction> transactionList = transactionRepository.findByAccountId(accountId);
		List<TransactionResponseDTO> transactionResponseDTOList = new ArrayList<>();
	
		for(Transaction transaction:transactionList)
		{
			transactionResponseDTOList.add(TransactionMapper.toDTO(transaction, accountResponseDTO));
		}
		return transactionResponseDTOList;

	}
}
