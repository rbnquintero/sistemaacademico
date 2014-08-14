package com.rbnquintero.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbnquintero.system.persistence.domain.Login;
import com.rbnquintero.system.persistence.domain.Maestro;
import com.rbnquintero.system.persistence.repository.MaestrosRepository;
import com.rbnquintero.system.service.MaestroService;

@Service
public class MaestroServiceImpl implements MaestroService{
	@Autowired
	MaestrosRepository maestroRepository;
	
	@Override
	public List<Maestro> findAllMaestros() {
		return maestroRepository.findAllMaestros();
	}
	
	@Override
	public Maestro findMaestroById(Long id){
		return maestroRepository.findOne(id);
	}

	@Override
	public Maestro findMaestroByLogin(Login login) {
		return maestroRepository.findMaestroByLogin(login);
	}
}