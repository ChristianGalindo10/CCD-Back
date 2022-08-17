package com.chm.ccd.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;


@Entity
@Table(name = "Ingrediente")
@JsonIgnoreProperties("producto_ingredientes")
public class Ingrediente {

	@Id
	@Column(name = "pk_idingrediente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idIngrediente;

	@NotNull
	@Column(name = "q_unidades")
	private Integer unidades;
	
	@NotNull
	@Column(name = "v_unidad_medida")
	private String unidadMedida;

	@NotNull
	@Column(name = "n_nombre", unique = true)
	private String nombre;
	
	@OneToMany(mappedBy = "ingrediente",fetch = FetchType.EAGER)
	@JsonManagedReference
    private List<Producto_Ingrediente> producto_ingredientes;
    
    @Transient
	private Integer cantidad;
	
	public Ingrediente() {}

	public Ingrediente(@NotNull Integer unidades,@NotNull String unidadMedida,@NotNull String nombre) {
		this.unidades = unidades;
		this.unidadMedida = unidadMedida;
		this.nombre = nombre;
	}
	

	@JsonProperty 
	public Integer getCantidad(){ 
		return cantidad;
	}
	
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public List<Producto_Ingrediente> getProducto_ingredientes() {
		return producto_ingredientes;
	}

	public void setProducto_ingredientes(List<Producto_Ingrediente> producto_ingredientes) {
		this.producto_ingredientes = producto_ingredientes;
	}

	public void setIdIngrediente(Long idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public Long getIdIngrediente() {
		return idIngrediente;
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
