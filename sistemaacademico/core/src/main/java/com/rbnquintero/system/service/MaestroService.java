package com.rbnquintero.system.service;

import java.util.List;

import com.rbnquintero.system.persistence.domain.Login;
import com.rbnquintero.system.persistence.domain.Maestro;

public interface MaestroService {
	
	public List<Maestro> findAllMaestros();
	
	public Maestro findMaestroById(Long id);
	
	public Maestro findMaestroByLogin(Login login);
}
