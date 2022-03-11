package com.example.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.AccountDTO3;
import com.example.dto.AccountDTO4;
import com.example.entity.Account;

@Service
public class AccountMapper {

	@Autowired
	private ModelMapper mapper;
	
	public Account convertToEntity(AccountDTO3 accountDTO3) {
		Account entity = mapper.map(accountDTO3, Account.class);
		
		return entity;
	}
	
	public Account convertToEntity2(AccountDTO4 accountDTO4) {
		Account entity = mapper.map(accountDTO4, Account.class);
		
		return entity;
	}
	
	public AccountDTO3 convertToDTO(Account entity) {
		AccountDTO3 accountDTO3 = mapper.map(entity, AccountDTO3.class);
		
		return accountDTO3;
	}
}
