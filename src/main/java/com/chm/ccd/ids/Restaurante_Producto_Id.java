package com.chm.ccd.ids;

import java.io.Serializable;

public class Restaurante_Producto_Id implements Serializable{
	
	private Long nit;
	private Integer idProducto;
	
	public Restaurante_Producto_Id(Long nit,Integer idProducto) {
		this.idProducto = idProducto;
		this.nit = nit;
	}

	public Restaurante_Producto_Id() {

	}
	
	
}
