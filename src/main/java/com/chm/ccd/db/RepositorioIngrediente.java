package com.chm.ccd.db;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chm.ccd.model.Ingrediente;

public interface RepositorioIngrediente extends JpaRepository<Ingrediente, Integer> {
	@Query(value = "SELECT ingrediente.*, producto_ingrediente.q_cantidad FROM ingrediente INNER JOIN producto_ingrediente "
			+ "ON ingrediente.pk_idingrediente=producto_ingrediente.pk_idingrediente "
			+ "WHERE producto_ingrediente.pk_idproducto=:pid", nativeQuery = true)
	List<Ingrediente> findIngredientsByProduct(@Param("pid") Integer pid);
	
	boolean existsByNombre(String nombre);
	Optional<Ingrediente> findByNombre(String name);
}
