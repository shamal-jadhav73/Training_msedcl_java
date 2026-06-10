package com.msedcl.main.account.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.msedcl.main.account.client.CustomerFeignClient;
import com.msedcl.main.account.client.CustomerRESTClient;
import com.msedcl.main.account.dto.AccountRequestDTO;
import com.msedcl.main.account.dto.AccountResponseDTO;
import com.msedcl.main.account.dto.BalanceUpdateRequestDTO;
import com.msedcl.main.account.dto.CustomerResponseDTO;
import com.msedcl.main.account.entity.Account;
import com.msedcl.main.account.exception.AccountNotFoundException;
import com.msedcl.main.account.exception.InsufficientBalanceException;
import com.msedcl.main.account.mapper.AccountMapper;
import com.msedcl.main.account.repository.AccountRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

	
	private final AccountRepository accountRepository;
	//private final CustomerRESTClient customerRESTClient;
	
	//we created feign client interface and made object of it to replace customerRESTClient
	private final CustomerFeignClient customerFeignClient;

	
	
	
	@Override
	public AccountResponseDTO createNewAccount(AccountRequestDTO accountRequestDTO) {

		CustomerResponseDTO customerResponseDTO = customerFeignClient
				.getSingleCustomer(accountRequestDTO.getCustomerId()).getBody().getData();
		
		
		Account account = AccountMapper.toEntity(accountRequestDTO);
     	Account savedAccount = accountRepository.save(account);
		AccountResponseDTO accountResponseDTO = AccountMapper.toDTO(savedAccount, customerResponseDTO);
		log.info(accountResponseDTO.toString());
		
		return accountResponseDTO;
		
	

	
	}


	

	@Override
	public AccountResponseDTO updateAccountBalance(BalanceUpdateRequestDTO balanceUpdateRequestDTO) {
		Optional<Account> optionalAccount=accountRepository.findById(balanceUpdateRequestDTO.getAccountId());
		Account savedAccount=null;
		
		 if(optionalAccount.isPresent())
		 {
			 if(balanceUpdateRequestDTO.getTransactionType().equalsIgnoreCase("WITHDRAW"))
			 {
				 if(optionalAccount.get().getBalance()>=balanceUpdateRequestDTO.getAmount())
				 {
					 double balance=optionalAccount.get().getBalance();
					 balance-=balanceUpdateRequestDTO.getAmount();
					 optionalAccount.get().setBalance(balance);
					 savedAccount=accountRepository.save(optionalAccount.get());
					 
					 
				 }
				 else
				 {
					throw new InsufficientBalanceException("Insufficient Account Balance::"+optionalAccount.get().getBalance()); 
				 }
			 }
			 
			 else if(balanceUpdateRequestDTO.getTransactionType().equalsIgnoreCase("DEPOSIT"))
			 {
				 double balance=optionalAccount.get().getBalance();
				 balance+=balanceUpdateRequestDTO.getAmount();
				 optionalAccount.get().setBalance(balance);
				 savedAccount=accountRepository.save(optionalAccount.get());
				 
			 }
			 
			 
			 
			 }
		 else throw new AccountNotFoundException("Account not Exist for id::");
		 
		 CustomerResponseDTO customerResponseDTO = customerFeignClient
					.getSingleCustomer(optionalAccount.get().getCustomerId()).getBody().getData();
		return AccountMapper.toDTO(savedAccount, customerResponseDTO);
	}




	@Override
	public AccountResponseDTO getAccountByAccountId(Integer accountId) {
		Optional<Account> Optionalaccount=accountRepository.findById(accountId);

      if(Optionalaccount.isPresent())
      {
    	  CustomerResponseDTO customerResponseDTO = customerFeignClient
  				.getSingleCustomer(Optionalaccount.get().getCustomerId()).getBody().getData();
    	  log.info(customerResponseDTO.toString());
  		  return AccountMapper.toDTO(Optionalaccount.get(), customerResponseDTO);
    	  
      }
      else throw new AccountNotFoundException("Invalid Account::"+accountId);
	}




	@Override
	public List<AccountResponseDTO> getAccountByCustomertId(Integer customerId) {
	
		
		
		CustomerResponseDTO customerResponseDTO = customerFeignClient
				.getSingleCustomer(customerId).getBody().getData();
		
		List<Account> accountList=accountRepository.findByCustomerId(customerId);
		List<AccountResponseDTO> accountResponseDTOList=new ArrayList<>();
		for(Account account:accountList)
		{
			accountResponseDTOList.add(AccountMapper.toDTO(account, customerResponseDTO));
		}
		return accountResponseDTOList;
	}


}
