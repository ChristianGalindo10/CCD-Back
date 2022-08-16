package com.chm.ccd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chm.ccd.db.RepositorioRestauranteProducto;
import com.chm.ccd.model.Restaurante_Producto;

@Service
public class ServicioRestauranteProducto {

	@Autowired
    RepositorioRestauranteProducto restaurantProductRepository;
	
	public void save(Restaurante_Producto restauranteProducto){
		restaurantProductRepository.save(restauranteProducto);
    }
	
	public Restaurante_Producto getProducto(Integer id){
		return restaurantProductRepository.findById(id);
    }
}
