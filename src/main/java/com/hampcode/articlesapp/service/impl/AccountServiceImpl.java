package com.hampcode.articlesapp.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.hampcode.articlesapp.exception.ResourceNotFoundException;
import com.hampcode.articlesapp.model.Account;
import com.hampcode.articlesapp.model.Course;
import com.hampcode.articlesapp.repository.AccountRepository;
import com.hampcode.articlesapp.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public Account getLoggedUser() {
		//Obtener el usuario logeado
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		UserDetails loggedUser = null;

		//Verificar que ese objeto traido de sesion es el usuario
		if (principal instanceof UserDetails) {
			loggedUser = (UserDetails) principal;
		}
		
		Account myUser = accountRepository.findByUserName(loggedUser.getUsername());
		
		return myUser;
	}


	@Override
	public Account findById(Long id) {
		Optional<Account> account=accountRepository.findById(id);
		
		if(!account.isPresent()) {
			throw new ResourceNotFoundException("There is no Account with ID = " + id);
		}
		return account.get();
	}
	
	/*@Override
	public Page<Account> finByUserName(String userName, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*@Override
	public Account findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}*/
}
