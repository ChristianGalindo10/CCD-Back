package com.chm.ccd.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Restaurante")
@JsonIgnoreProperties({"pedidos","menus","restaurante_productos"})
public class Restaurante {

	@Id
	@Column(name = "pk_nit")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nit;

	@NotNull
	@Column(name = "n_nombre", unique = true)
	private String nombre;

	@NotNull
	@Column(name = "n_telefono", unique = true)
	private Long telefono;

	@NotNull
	@Column(name = "n_especialidad")
	private String especialidad;
	
	@NotNull
	@Column(name = "p_contraseniarestaurante")
	private String password;
	
	@NotNull
	@Column(name = "p_correorestaurante", unique = true)
	private String email;
	
	@OneToMany(mappedBy = "restaurante",fetch = FetchType.EAGER)
	@JsonManagedReference
    private List<Menu> menus;
	
	@OneToMany(mappedBy = "restaurante",fetch = FetchType.EAGER)
	@JsonManagedReference
    private List<Restaurante_Producto> restaurante_productos;
    
    @ManyToMany(mappedBy = "restaurantes",fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Pedido> pedidos;
	
	public Restaurante() {}

	public Restaurante(@NotNull Long nit,@NotNull String nombre,@NotNull Long telefono,@NotNull String especialidad,@NotNull String email,@NotNull String password) {
		this.nit = nit;
		this.nombre = nombre;
		this.telefono = telefono;
		this.especialidad = especialidad;
		this.email = email;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getNit() {
		return nit;
	}

	public void setNit(Long nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	
	
}
