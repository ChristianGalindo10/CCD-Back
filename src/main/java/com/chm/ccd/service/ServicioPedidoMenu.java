package com.chm.ccd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chm.ccd.db.RepositorioPedidoMenu;
import com.chm.ccd.model.Pedido_Menu;
import com.chm.ccd.model.Producto_Ingrediente;

@Service
public class ServicioPedidoMenu {

	@Autowired
    RepositorioPedidoMenu pedidoMenuRepository;
	
	
	public void save(Pedido_Menu pedidoMenu){
		pedidoMenuRepository.save(pedidoMenu);
    }
	
	public Integer getQuantity(int idp,Integer mid){
		Pedido_Menu p = pedidoMenuRepository.findByIdMenu(idp, mid).get();
		return p.getCantidad();
	}
}
