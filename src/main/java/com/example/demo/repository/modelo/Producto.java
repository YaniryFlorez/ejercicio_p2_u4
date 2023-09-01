package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
@Entity
@Table(name="producto")
public class Producto {
	@Id
	@GeneratedValue(generator = "seq_prd", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_prd", sequenceName = "seq_prd", allocationSize = 1)
	@Column(name="prd_id")
	private Integer id;
	@Column(name="prd_nombre")
	private String nombre;
	@Column(name="prd_codigo_barras_maestro")
	private String codigoBarrasMaestro;
	@Column(name="prd_categoria")
	private String categoria;
	@Column(name="prd_stock")
	private Integer stock=0;
	
	@OneToMany(mappedBy = "producto")
	private List<Inventario> inventarios;
	
	/// GET Y SET ///
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoBarrasMaestro() {
		return codigoBarrasMaestro;
	}

	public void setCodigoBarrasMaestro(String codigoBarrasMaestro) {
		this.codigoBarrasMaestro = codigoBarrasMaestro;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<Inventario> getInventarios() {
		return inventarios;
	}

	public void setInventarios(List<Inventario> inventarios) {
		this.inventarios = inventarios;
	}
	
	
}
