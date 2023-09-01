package com.example.demo.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
@Entity
@Table(name="inventario")
public class Inventario {
	@Id
	@GeneratedValue(generator = "seq_inv", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_inv", sequenceName = "seq_inv", allocationSize = 1)
	@Column(name="inv_id")
	private Integer id;
	@Column(name="inv_cantidad")
	private Integer cantidad;
	@Column(name="inv_cod_barras_individual")
	private String codigoBarrasIndiv ;
	
	@ManyToOne()
	@JoinColumn(name = "inv_id_bodega")
	private Bodega bodega;
	
	@ManyToOne()
	@JoinColumn(name = "inv_id_producto")
	private Producto producto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getCodigoBarrasIndiv() {
		return codigoBarrasIndiv;
	}

	public void setCodigoBarrasIndiv(String codigoBarrasIndiv) {
		this.codigoBarrasIndiv = codigoBarrasIndiv;
	}

	
	
}
