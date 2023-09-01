package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProductoRepository;
import com.example.demo.repository.modelo.Producto;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private IProductoRepository productoRepository;

	
	@Transactional( value = TxType.REQUIRED)
	@Override
	public void crear(Producto producto) {
		// TODO Auto-generated method stub
		this.productoRepository.insertar(producto);
	}

     
	@Transactional(value = TxType.NOT_SUPPORTED)
	@Override
	public Producto buscarPorCodigoBarras(String codigoBarras) {
		
		return this.productoRepository.buscarPorCodigoBarras(codigoBarras);
	}

}
