package com.chm.ccd.ids;

public class Restaurante_Producto_Id {
	
	private Long nit;
	private Integer idProducto;
	
	public Restaurante_Producto_Id(Long nit,Integer idProducto) {
		this.idProducto = idProducto;
		this.nit = nit;
	}
}
