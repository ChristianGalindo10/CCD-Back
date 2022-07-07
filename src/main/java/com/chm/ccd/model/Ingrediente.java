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

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;


@Entity
@Table(name = "Ingrediente")
public class Ingrediente {

	@Id
	@Column(name = "pk_idIngrediente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIngrediente;

	@Column(name = "q_unidades")
	private Integer unidades;
	
	@NotNull
	@Column(name = "v_unidad_medida")
	private String unidadMedida;

	@NotNull
	@Column(name = "n_nombre", unique = true)
	private String nombre;
	
	@OneToMany(mappedBy = "Ingrediente",fetch = FetchType.EAGER)
	@JsonManagedReference
    private List<Producto_Ingrediente> producto_ingredientes;
	
	public Ingrediente() {}

	public Ingrediente(Integer unidades,@NotNull String unidadMedida,@NotNull String nombre) {
		this.unidades = unidades;
		this.unidadMedida = unidadMedida;
		this.nombre = nombre;
	}

	
	public List<Producto_Ingrediente> getProducto_ingredientes() {
		return producto_ingredientes;
	}

	public void setProducto_ingredientes(List<Producto_Ingrediente> producto_ingredientes) {
		this.producto_ingredientes = producto_ingredientes;
	}

	public void setIdIngrediente(Integer idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public int getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	
	
	
}
