package com.rbnquintero.system.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rbnquintero.system.persistence.domain.Login;


public interface LoginRepository extends PagingAndSortingRepository<Login, Long> {
	
	@Query("from Login")
	public List<Login> findAllLogin();
	
	@Query("from Login where username = ?1 and password = ?2")
	public Login findLoginByUsernameAndPassword(String username, String password);

}
