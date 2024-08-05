package com.debnath.Shopmannager.service.impl;

import com.debnath.Shopmannager.entity.Account;
import com.debnath.Shopmannager.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debnath.Shopmannager.dto.AccountDto;
import com.debnath.Shopmannager.repository.AccountRepository;
import com.debnath.Shopmannager.service.AccountService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService{
	
	private AccountRepository accountRepository;


	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account= AccountMapper.mapToAccount(accountDto);
		Account savedAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Does Not Exist"));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long id, Double amount) {
		Account account= accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Does Not Exist"));
		double NetBalance=account.getBalance()+ amount;
		account.setBalance(NetBalance);
		Account savedac=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedac);
	}

	@Override
	public AccountDto withdraw(Long id, Double amount) {
		Account account= accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Does Not Exist"));
		if(account.getBalance()<amount){
			throw new RuntimeException("Insufficient Balance");
		}
		double NetBalance=account.getBalance()- amount;
		account.setBalance(NetBalance);
		Account savedac=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedac);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accounts=accountRepository.findAll();
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());

	}

	@Override
	public void deleteAccount(Long id) {
		Account account= accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Does Not Exist"));
		accountRepository.deleteById(id);
	}

}
