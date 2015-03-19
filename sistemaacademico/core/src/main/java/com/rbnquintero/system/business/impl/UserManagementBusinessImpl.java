package com.rbnquintero.system.business.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbnquintero.system.business.UserManagementBusiness;
import com.rbnquintero.system.exception.UtilException;
import com.rbnquintero.system.persistence.domain.Login;
import com.rbnquintero.system.service.LoginService;
import com.rbnquintero.system.util.EncryptionUtils;

@Service
public class UserManagementBusinessImpl implements UserManagementBusiness {
	private static final Logger log = LoggerFactory.getLogger(UserManagementBusinessImpl.class);

	@Autowired
	private LoginService loginService;

	@Override
	public boolean validUserAndPassword(String username, String password) {
		Login usrLogin = loginService.findLoginByUsername(username);

		try {
			if (usrLogin != null && EncryptionUtils.checkPassword(password, usrLogin.getPassword())) {
				return true;
			}
		} catch (UtilException ue) {
			log.error("No se pudo validar el password: " + password, ue);
		}

		return false;
	}
}
