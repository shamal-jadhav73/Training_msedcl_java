package com.msedcl.main.transaction.service;

import java.util.List;


import com.msedcl.main.transaction.dto.TransactionRequestDTO;
import com.msedcl.main.transaction.dto.TransactionResponseDTO;

public interface TransactionService {

	
	TransactionResponseDTO depositAmount(TransactionRequestDTO dto);
	TransactionResponseDTO withdrawAmount(TransactionRequestDTO dto);
	List<TransactionResponseDTO> getTransactionsByAccountId(int transactionId);
}
