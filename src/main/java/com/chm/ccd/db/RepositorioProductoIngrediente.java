package com.chm.ccd.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chm.ccd.ids.Producto_Ingrediente_Id;
import com.chm.ccd.model.Producto_Ingrediente;

public interface RepositorioProductoIngrediente extends JpaRepository<Producto_Ingrediente, Producto_Ingrediente_Id>{
}