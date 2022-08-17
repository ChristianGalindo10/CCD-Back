package com.chm.ccd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.chm.ccd.ids.Pedido_Menu_Id;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Pedido_Menu")
@IdClass(Pedido_Menu_Id.class)
public class Pedido_Menu {
	@Id
	@Column(name = "pk_idpedido")
    private Integer idPedido;

    @Id
    @Column(name = "pk_idmenu")
    private Integer idMenu;

    @NotNull
    @Column(name = "q_cantidad")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "pk_idmenu",insertable = false, updatable = false)
    @JsonBackReference
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "pk_idpedido",insertable = false, updatable = false)
    @JsonBackReference
    private Pedido pedido;

	public Pedido_Menu(Integer idPedido, Integer idMenu, Integer cantidad) {
		super();
		this.idPedido = idPedido;
		this.idMenu = idMenu;
		this.cantidad = cantidad;
	}
	
	public Pedido_Menu() {}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
    
    
}
