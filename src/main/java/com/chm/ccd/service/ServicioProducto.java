package com.chm.ccd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chm.ccd.db.RepositorioProducto;
import com.chm.ccd.model.Producto;


@Service
public class ServicioProducto {
	
	@Autowired
    RepositorioProducto productRepository;
	
	public void save(Producto producto){
		productRepository.save(producto);
    }
	

}
