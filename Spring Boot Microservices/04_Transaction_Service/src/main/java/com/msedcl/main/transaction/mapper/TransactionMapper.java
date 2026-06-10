package com.msedcl.main.transaction.mapper;

import com.msedcl.main.transaction.dto.AccountResponseDTO;
import com.msedcl.main.transaction.dto.TransactionRequestDTO;
import com.msedcl.main.transaction.dto.TransactionResponseDTO;
import com.msedcl.main.transaction.entity.Transaction;

public class TransactionMapper {

	public static Transaction toEntity(TransactionRequestDTO transactionRequestDTO) {
		Transaction transaction = new Transaction();
		transaction.setAccountId(transactionRequestDTO.getAccountId());
		transaction.setAmount(transactionRequestDTO.getAmount());
		return transaction;

	}

	public static TransactionResponseDTO toDTO(Transaction transaction, AccountResponseDTO accountResponseDTO) {

		TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();
		transactionResponseDTO.setAccountResponseDTO(accountResponseDTO);
		transactionResponseDTO.setAmount(transaction.getAmount());
		transactionResponseDTO.setTransactionDate(transaction.getTransactionDate());
		transactionResponseDTO.setTransactionId(transaction.getTransactionId());
		transactionResponseDTO.setTransactionType(transaction.getTransactionType());

		return transactionResponseDTO;
	}

}
