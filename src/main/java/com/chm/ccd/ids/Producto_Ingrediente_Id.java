package com.chm.ccd.ids;

import java.io.Serializable;

public class Producto_Ingrediente_Id implements Serializable{
	
	private Integer idProducto;
	private Long idIngrediente;
	
	public Producto_Ingrediente_Id(Integer idProducto,Long idIngrediente) {
		this.idProducto = idProducto;
		this.idIngrediente = idIngrediente;
	}

	public Producto_Ingrediente_Id() {

	}
	
	
}
