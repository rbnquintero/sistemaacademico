package com.rbnquintero.system.service;

import com.rbnquintero.system.persistence.domain.Login;

public interface LoginService {
	
	public Login findLoginByUsernameAndPassword(String username, String password);
	
	public Login findLoginByUsername(String username);
}