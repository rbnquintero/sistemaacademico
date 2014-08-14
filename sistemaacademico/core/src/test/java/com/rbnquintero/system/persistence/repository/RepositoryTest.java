package com.rbnquintero.system.persistence.repository;

import java.util.Iterator;
import java.util.List;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rbnquintero.system.config.PersistenceConfig;
import com.rbnquintero.system.config.SpringConfig;
import com.rbnquintero.system.persistence.domain.Login;
import com.rbnquintero.system.persistence.domain.Maestro;
import com.rbnquintero.system.util.ConstantesCore;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, SpringConfig.class })
public class RepositoryTest {
	private static final Logger _log = LoggerFactory.getLogger(RepositoryTest.class);

	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private MaestrosRepository maestrosRepository;

	@Test
	public void LoginTest() {
		List<Login> loginList = loginRepository.findAllLogin();
		Iterator<Login> it = loginList.iterator();
		Login login = null;
		Maestro maestro = null;
		while (it.hasNext()) {
			login = it.next();
			_log.debug(login.getUsername());
			StandardPBEStringEncryptor s = new StandardPBEStringEncryptor();
			s.setPassword(ConstantesCore.ENCRIPT_PASSWD);
			_log.debug(s.decrypt(login.getPassword()));
			maestro = maestrosRepository.findMaestroByLogin(login);
			_log.debug(maestro.getNombre());
		}
	}
}