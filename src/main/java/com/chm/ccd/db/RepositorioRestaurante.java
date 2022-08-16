package com.chm.ccd.db;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chm.ccd.model.Restaurante;

public interface RepositorioRestaurante extends JpaRepository<Restaurante, Integer>{
	
	@Query(value = "SELECT * FROM restaurante  WHERE pk_nit=:nit", nativeQuery = true)
	Restaurante findByNit(@Param("nit") Long nit);
	
	Optional<Restaurante> findByNombre(String name);
	Optional<Restaurante> findByEmail(String email);
	boolean existsByEmail(String email);
	boolean existsByNit(Long nit);
}
