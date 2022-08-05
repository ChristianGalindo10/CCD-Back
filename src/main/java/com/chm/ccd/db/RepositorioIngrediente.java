package com.chm.ccd.db;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chm.ccd.model.Ingrediente;

public interface RepositorioIngrediente extends JpaRepository<Ingrediente, Integer> {
	boolean existsByNombre(String nombre);
	Optional<Ingrediente> findByNombre(String name);
}
