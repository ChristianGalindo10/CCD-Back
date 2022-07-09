package com.chm.ccd.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Producto")
public class Producto {

	@Id
	@Column(name = "pk_idProducto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	
	@NotNull
	@Column(name = "n_nombre")
	private String nombre;
	
	@NotNull
	@Column(name = "i_tipo")
	private String tipo;
	
	@NotNull
	@Column(name = "i_personalizable")
	private boolean personalizable;
	
	@NotNull
	@Column(name = "v_precio")
	private Long precio;
	
	@Column(name = "i_foto", length = 10000)
	private byte[] picByte;
	
	@OneToMany(mappedBy = "producto",fetch = FetchType.EAGER)
	@JsonManagedReference
    private List<Producto_Ingrediente> producto_ingredientes;
    
    @OneToMany(mappedBy = "producto",fetch = FetchType.EAGER)
	@JsonManagedReference
    private List<Restaurante_Producto> restaurante_productos;
    
    @OneToMany(mappedBy = "producto",fetch = FetchType.EAGER)
	@JsonManagedReference
    private List<Pedido_Producto> pedidos_productos;
    
    @ManyToMany(mappedBy = "productos",fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Menu> menus;
    

	public Producto() {}
	
	public Producto(@NotNull String nombre,@NotNull String tipo,@NotNull boolean personalizable,@NotNull Long precio,
			byte[] picByte) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.personalizable = personalizable;
		this.precio = precio;
		this.picByte = picByte;
	}

	public List<Producto_Ingrediente> getProducto_ingredientes() {
		return producto_ingredientes;
	}

	public void setProducto_ingredientes(List<Producto_Ingrediente> producto_ingredientes) {
		this.producto_ingredientes = producto_ingredientes;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isPersonalizable() {
		return personalizable;
	}

	public void setPersonalizable(boolean personalizable) {
		this.personalizable = personalizable;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	};
	
	
	
	
}
