package com.rbnquintero.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.rbnquintero.system.persistence.domain.Login;
import com.rbnquintero.system.persistence.repository.LoginRepository;
import com.rbnquintero.system.service.LoginService;

public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public Login findLoginByUsernameAndPassword(String username, String password) {
		return loginRepository.findLoginByUsernameAndPassword(username, password);
	}

}
