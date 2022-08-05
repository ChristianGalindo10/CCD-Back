package com.chm.ccd.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



import com.chm.ccd.ids.Producto_Ingrediente_Id;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Producto_Ingrediente")
@IdClass(Producto_Ingrediente_Id.class)
public class Producto_Ingrediente {

	@Id
	@Column(name = "pk_idproducto")
    private Integer idProducto;

    @Id
    @Column(name = "pk_idingrediente")
    private Long idIngrediente;

    @NotNull
    @Column(name = "q_cantidad")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "pk_idproducto" ,insertable = false, updatable = false)
    @JsonBackReference
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "pk_idingrediente", insertable = false, updatable = false)
    @JsonBackReference
    private Ingrediente ingrediente;
    
    public Producto_Ingrediente() {}
    
	public Producto_Ingrediente(Integer idProducto, Long idIngrediente, Integer cantidad) {
		this.idProducto = idProducto;
		this.idIngrediente = idIngrediente;
		this.cantidad = cantidad;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Long getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(Long idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
}
