package com.chm.ccd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chm.ccd.db.RepositorioPedidoProducto;
import com.chm.ccd.model.Pedido_Producto;

@Service
public class ServicioPedidoProducto {
	
	@Autowired
    RepositorioPedidoProducto pedidoProductRepository;
	
	public void save(Pedido_Producto pedidoProducto){
		pedidoProductRepository.save(pedidoProducto);
    }

}
