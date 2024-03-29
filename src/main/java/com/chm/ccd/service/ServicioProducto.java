package com.chm.ccd.service;

import java.util.List;
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
	
	public List<Producto> getProductsByNit(Long nit){
		return productRepository.findProductsByNit(nit);
	}
	
	public List<Producto> getProductsByMenu(int idm){
		return productRepository.findProductsByMenu(idm);
	}
	
	public List<Producto> getProductsByPedido(int idp){
		return productRepository.findProductsByPedido(idp);
	}
	

}
