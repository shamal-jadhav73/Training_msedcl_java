package com.msedcl.main.account.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDTO {
    
 	private int customerId;
    @NotBlank(message="Account type cannot be blank")
	@Length(min = 2, max = 10)
    private String accountType;
}
