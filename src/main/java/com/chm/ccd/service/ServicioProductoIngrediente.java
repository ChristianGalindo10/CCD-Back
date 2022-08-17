package com.chm.ccd.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chm.ccd.db.RepositorioProductoIngrediente;
import com.chm.ccd.model.Producto_Ingrediente;

@Service
public class ServicioProductoIngrediente {
	
	@Autowired
    RepositorioProductoIngrediente productIngredientRepository;
	
	public void save(Producto_Ingrediente productoIngrediente){
		productIngredientRepository.save(productoIngrediente);
    }
	
	public Integer getQuantity(Integer pid){
		Producto_Ingrediente p = productIngredientRepository.findByIdProducto(pid).get();
		return p.getCantidad();
	}
}
