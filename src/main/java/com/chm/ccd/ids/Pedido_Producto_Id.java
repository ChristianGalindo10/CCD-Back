package com.chm.ccd.ids;

import java.io.Serializable;

public class Pedido_Producto_Id implements Serializable{
	
	private Integer idPedido;
	private Integer idProducto;
	
	public Pedido_Producto_Id(Integer idPedido, Integer idProducto) {
		this.idPedido = idPedido;
		this.idProducto = idProducto;
	}
}
