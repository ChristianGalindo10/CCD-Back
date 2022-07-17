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
import javax.persistence.Transient;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Pedido")
public class Pedido {

	@Id
	@Column(name = "pk_idpedido")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;

	@NotNull
	@Column(name = "v_monto")
	private Long monto;

	@NotNull
	@Column(name = "a_direccion")
	private String direccion;

	@NotNull
	@Column(name = "f_fecha")
	private LocalDate fecha;

	@ManyToOne
	@JoinColumn(name = "pk_identificador")
	@JsonBackReference
	private Usuario usuario;

	@OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Pedido_Producto> pedidos_productos;
	
	@OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Pedido_Menu> pedidos_menus;
	
	@JoinTable(
	        name = "Pedido_Restaurante",
	        joinColumns = @JoinColumn(name = "pk_nit", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="pk_idPedido", nullable = false)
	    )
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Restaurante> restaurantes;

	// @Transient
	// private Long idUsuario;

	public Pedido() {
	}

	public Pedido(@NotNull Long monto, @NotNull String direccion, @NotNull LocalDate fecha) {
		this.monto = monto;
		this.direccion = direccion;
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Long getMonto() {
		return monto;
	}

	public void setMonto(Long monto) {
		this.monto = monto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}
