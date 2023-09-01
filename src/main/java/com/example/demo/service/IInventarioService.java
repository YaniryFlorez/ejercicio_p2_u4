package com.example.demo.service;

import com.example.demo.repository.modelo.Inventario;

public interface IInventarioService {

	public void crear(Inventario inventario);
	
	public void crearInventario(String numeroBodega, String codigoBarras, Integer cantidad);
	
}
