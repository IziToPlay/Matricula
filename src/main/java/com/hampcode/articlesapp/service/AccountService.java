package com.hampcode.articlesapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hampcode.articlesapp.model.Account;

public interface AccountService {
	
	Account findById(Long id);
	
	//Account findByUserName(String userName);
	
	//Page<Account> finByUserName(String userName,Pageable pageable);
}
