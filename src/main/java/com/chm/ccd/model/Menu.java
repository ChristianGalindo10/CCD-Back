package com.chm.ccd.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Menu")
public class Menu {

	@Id
	@Column(name = "pk_idmenu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMenu;
	
	@NotNull
	@Column(name = "n_nombre")
	private String nombre;
	
	@NotNull
	@Column(name = "i_personalizable")
	private boolean personalizable;
	
	
	@Column(name = "i_foto", length = 10000)
	private byte[] picByte;
	
	@NotNull
	@Column(name = "v_precio")
	private Long precio;
	
	@ManyToOne
    @JoinColumn(name = "pk_nit")
	@JsonBackReference
    private Restaurante restaurante;
	
	@OneToMany(mappedBy = "menu",fetch = FetchType.EAGER)
	@JsonManagedReference
    private List<Pedido_Menu> pedidos_menus;
    
    @JoinTable(
	        name = "Producto_Menu",
	        joinColumns = @JoinColumn(name = "pk_idmenu", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="pk_idproducto", nullable = false)
	    )
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Producto> productos;
	
	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public List<Pedido_Menu> getPedidos_menus() {
		return pedidos_menus;
	}

	public void setPedidos_menus(List<Pedido_Menu> pedidos_menus) {
		this.pedidos_menus = pedidos_menus;
	}

	public Menu() {}

	public Menu(@NotNull String nombre,@NotNull boolean personalizable,byte[] picByte,@NotNull Long precio){
		this.nombre = nombre;
		this.personalizable = personalizable;
		this.picByte = picByte;
		this.precio = precio;
	}

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isPersonalizable() {
		return personalizable;
	}

	public void setPersonalizable(boolean personalizable) {
		this.personalizable = personalizable;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}
	
	
	
}
