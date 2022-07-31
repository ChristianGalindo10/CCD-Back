package com.chm.ccd.db;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chm.ccd.model.Restaurante;

public interface RepositorioRestaurante extends JpaRepository<Restaurante, Integer>{
	Optional<Restaurante> findByNit(Long nit);
	Optional<Restaurante> findByNombre(String name);
	Optional<Restaurante> findByEmail(String email);
	boolean existsByEmail(String email);
	boolean existsByNit(Long nit);
}
