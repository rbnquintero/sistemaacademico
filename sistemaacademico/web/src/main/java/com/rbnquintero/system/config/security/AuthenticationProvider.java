package com.rbnquintero.system.config.security;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.rbnquintero.system.business.UserManagementBusiness;
import com.rbnquintero.system.exception.UtilException;
import com.rbnquintero.system.util.ConstantesWeb;
import com.rbnquintero.system.util.EncryptionUtils;

@Service("authProvider")
public class AuthenticationProvider {

	@Autowired
	private UserManagementBusiness userBusiness;

	public Authentication authenticateByDB(String username, String password, HttpSession session) {
		Authentication userAuth = postAuthentication(session, username, password);
		return userAuth;
	}

	private Authentication postAuthentication(HttpSession session, String username, String password) {
		if (!userBusiness.validUserAndPassword(username, password)) {
			throw new BadCredentialsException(ConstantesWeb.SS_AUTENTICACION);
		}

		try {
			UserCredentials credentials = new UserCredentials(username, EncryptionUtils.encryptPassword(password));

			Authentication userAuth = new UsernamePasswordAuthenticationToken(username, credentials,
					new ArrayList<GrantedAuthority>());
			return userAuth;
		} catch (UtilException ue) {
			ue.printStackTrace();
			throw new AuthenticationServiceException(ConstantesWeb.SS_ERROR_INTERNO, ue);
		}
	}

}
