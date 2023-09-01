package com.example.demo.service;
import com.example.demo.repository.modelo.Producto;

public interface IProductoService {
     
	public void crear(Producto producto);
	
	public Producto buscarPorCodigoBarras(String codigoBarras);
	
}
