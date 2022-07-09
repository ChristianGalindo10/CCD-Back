package com.chm.ccd.ids;

import java.io.Serializable;

public class Pedido_Menu_Id implements Serializable{

	private Integer idPedido;
	private Integer idMenu;
	
	public Pedido_Menu_Id(Integer idPedido, Integer idMenu) {
		this.idPedido = idPedido;
		this.idMenu = idMenu;
	}
	
	
}
