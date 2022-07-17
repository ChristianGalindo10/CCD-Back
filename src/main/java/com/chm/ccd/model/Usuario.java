package com.chm.ccd.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Usuario")
@JsonIgnoreProperties("pedidos")
public class Usuario {

	@Id
	@Column(name = "pk_identificador")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "n_nombre")
	private String name;

	@NotNull
	@Column(name = "n_celular", unique = true)
	private Long celular;

	@NotNull
	@Column(name = "n_tipo")
	private String tipo;
	
	@NotNull
	@Column(name = "p_contrasenia")
	private String password;
	
	//@NotNull
	//@Column(name = "p_correo", unique = true)
	//private String email;
	
	@OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER)
	@JsonManagedReference
    private List<Pedido> pedidos;
	
	public Usuario() {	
	}
	
	public Usuario(@NotNull String name,@NotNull Long celular,@NotNull String email ,@NotNull String tipo,@NotNull String password) {
		this.name = name;
		this.celular = celular;
		//this.email = email;
		this.tipo = tipo;
		this.password = password;
	}

	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	/*
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}*/

	

}
