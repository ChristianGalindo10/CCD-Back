package com.chm.ccd.db;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.chm.ccd.model.Producto;

public interface RepositorioProducto extends JpaRepository<Producto, Integer>{
	
	@Query(value = "SELECT producto.* FROM producto INNER JOIN restaurante_producto "
			+ "ON producto.pk_idproducto=restaurante_producto.pk_idproducto "
			+ "WHERE restaurante_producto.pk_nit=:nit", nativeQuery = true)
	List<Producto> findProductsByNit(@Param("nit") Long nit);
	
	Optional<Producto> findByNombre(String name);
	
	@Query(value = "SELECT producto.* FROM producto INNER JOIN producto_menu "
			+ "ON producto.pk_idproducto=producto_menu.pk_idproducto "
			+ "WHERE producto_menu.pk_idmenu=:idm", nativeQuery = true)
	List<Producto> findProductsByMenu(@Param("idm") int idm);
}
