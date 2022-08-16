package com.chm.ccd.db;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chm.ccd.ids.Restaurante_Producto_Id;
import com.chm.ccd.model.Restaurante_Producto;

public interface RepositorioRestauranteProducto extends JpaRepository<Restaurante_Producto, Restaurante_Producto_Id>{
	
	@Query(value = "SELECT * FROM restaurante_producto  WHERE pk_idproducto=:id", nativeQuery = true)
	Restaurante_Producto findById(@Param("id") Integer id);
}
