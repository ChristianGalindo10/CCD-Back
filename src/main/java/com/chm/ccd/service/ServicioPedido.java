package com.chm.ccd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chm.ccd.db.RepositorioPedido;
import com.chm.ccd.model.Pedido;

@Service
public class ServicioPedido {

	@Autowired
    RepositorioPedido pedidoRepository;
	
	public Pedido save(Pedido pedido){
		return pedidoRepository.save(pedido);
    }
		
	public List<Pedido> getPedidosById(Long id){
		return pedidoRepository.findPedidosById(id);
	}
}
