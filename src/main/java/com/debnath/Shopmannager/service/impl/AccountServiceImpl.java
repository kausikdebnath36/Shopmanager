package com.debnath.Shopmannager.service.impl;

import org.springframework.stereotype.Service;

import com.debnath.Shopmannager.dto.AccountDto;
import com.debnath.Shopmannager.repository.AccountRepository;
import com.debnath.Shopmannager.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	private AccountRepository accountRepository;


	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
