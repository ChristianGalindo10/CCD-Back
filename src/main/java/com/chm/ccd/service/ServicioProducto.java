package com.chm.ccd.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chm.ccd.db.RepositorioProducto;
import com.chm.ccd.model.Producto;


@Service
public class ServicioProducto {
	
	@Autowired
    RepositorioProducto productRepository;
	
	public Producto save(Producto producto){
		return productRepository.save(producto);
    }
	
	public Optional<Producto> getByName(String name){
        return productRepository.findByNombre(name);
    }
	

}
