package com.chm.ccd.db;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chm.ccd.model.Ingrediente;
import com.chm.ccd.model.Restaurante;

public interface RepositorioIngrediente extends JpaRepository<Ingrediente, Integer> {
	boolean existsByNombre(String nombre);

}
