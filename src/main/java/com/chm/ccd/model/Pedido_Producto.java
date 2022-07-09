package com.chm.ccd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.chm.ccd.ids.Pedido_Menu_Id;
import com.chm.ccd.ids.Pedido_Producto_Id;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;


@Entity
@Table(name = "Pedido_Producto")
@IdClass(Pedido_Producto_Id.class)
public class Pedido_Producto {
	
	@Id
	@Column(name = "pk_idPedido")
    private Integer idPedido;

    @Id
    @Column(name = "pk_idProducto")
    private Integer idProducto;

    @NotNull
    @Column(name = "q_cantidad")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "pk_idProducto",insertable = false, updatable = false)
    @JsonBackReference
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "pk_idPedido",insertable = false, updatable = false)
    @JsonBackReference
    private Pedido pedido;

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
    
    
}
