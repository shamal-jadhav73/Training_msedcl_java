package com.msedcl.main.transaction.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.msedcl.main.transaction.dto.AccountResponseDTO;
import com.msedcl.main.transaction.dto.BalanceUpdateRequestDTO;
import com.msedcl.main.transaction.exception.AccountNotFoundException;
import com.msedcl.main.transaction.common.ApiResponse;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountRestClient {

	private final RestTemplate restTemplate;

	public AccountResponseDTO getAccountByAccountId(int accountId) {

		try {
			String url = "http://localhost:8181/accountapi/accounts/account/" + accountId;

			ResponseEntity<ApiResponse<AccountResponseDTO>> response = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<ApiResponse<AccountResponseDTO>>() {
					});

			return response.getBody().getData();

		} catch (HttpClientErrorException.NotFound e) {
			throw new AccountNotFoundException("Invalid AccountId::" + accountId);
		}
	}

	public AccountResponseDTO UpdateBalance(BalanceUpdateRequestDTO balanceUpdateRequestDTO) {
		
		
		String url = "http://localhost:8181/accountapi/accounts/updateAccount";

		HttpEntity<BalanceUpdateRequestDTO> entity = new HttpEntity<>(balanceUpdateRequestDTO);
		
		
		ResponseEntity<ApiResponse<AccountResponseDTO>> response = restTemplate.exchange(url, 
				                                                                         HttpMethod.PUT, 
				                                                                          entity,
				                          new ParameterizedTypeReference<ApiResponse<AccountResponseDTO>>() {
				});
		
		return response.getBody().getData();
		
	}

}
