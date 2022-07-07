package com.chm.ccd.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chm.ccd.ids.Restaurante_Producto_Id;
import com.chm.ccd.model.Restaurante_Producto;

public interface RepositorioRestauranteProducto extends JpaRepository<Restaurante_Producto, Restaurante_Producto_Id>{

}
