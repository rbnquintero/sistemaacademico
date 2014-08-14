package com.rbnquintero.system.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rbnquintero.system.persistence.domain.Login;
import com.rbnquintero.system.persistence.domain.Maestro;

public interface MaestrosRepository extends PagingAndSortingRepository<Maestro, Long> {
	
	@Query("from Maestro")
	public List<Maestro> findAllMaestros();
	
	public Maestro findMaestroByLogin(Login login);

}
