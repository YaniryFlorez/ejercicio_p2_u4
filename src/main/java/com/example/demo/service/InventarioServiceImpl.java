package com.example.demo.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IBodegaRepository;
import com.example.demo.repository.IInventarioRepository;
import com.example.demo.repository.IProductoRepository;
import com.example.demo.repository.modelo.Bodega;
import com.example.demo.repository.modelo.Inventario;
import com.example.demo.repository.modelo.Producto;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class InventarioServiceImpl implements IInventarioService {

	@Autowired
	private IInventarioRepository inventarioRepository;

	@Autowired
	private IBodegaRepository bodegaRepository;

	@Autowired
	private IProductoRepository productoRepository;

	@Transactional(value = TxType.REQUIRED)
	@Override
	public void crear(Inventario inventario) {
		// TODO Auto-generated method stub
		this.inventarioRepository.insertar(inventario);
	}

	@Transactional(value = TxType.REQUIRED)
	@Override
	public void crearInventario(String numeroBodega, String codigoBarras, Integer cantidad) {

		Bodega bodega = this.bodegaRepository.buscarPorNumero(numeroBodega);
		Producto producto = this.productoRepository.buscarPorCodigoBarras(codigoBarras);
		
		for (int i = 0; i < cantidad; i++) {
			
			Inventario inve = new Inventario();
			inve.setBodega(bodega);
			inve.setProducto(producto);
			inve.setCantidad(cantidad);
			inve.setCodigoBarrasIndiv(codigoBarras + i);
			
			this.inventarioRepository.insertar(inve);

		}
		this.productoRepository.actualizarStock(producto.getId(),cantidad);
	}

}
