package com.debnath.Shopmannager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AccountDto {

	private Long id;
	private String accountHolderName;
	private double balance;

}
