package com.chm.ccd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.chm.ccd.ids.Pedido_Menu_Id;
import com.chm.ccd.ids.Restaurante_Producto_Id;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Restaurante_Producto")
@IdClass(Restaurante_Producto_Id.class)
public class Restaurante_Producto {

	@Id
	@Column(name = "pk_nit")
    private Long nit;

    @Id
    @Column(name = "pk_idProducto")
    private Integer idProducto;

    @NotNull
    @Column(name = "q_stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "pk_idProducto",insertable = false, updatable = false)
    @JsonBackReference
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "pk_nit",insertable = false, updatable = false)
    @JsonBackReference
    private Restaurante restaurante;

	public Long getNit() {
		return nit;
	}

	public void setNit(Long nit) {
		this.nit = nit;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
    
    
}
