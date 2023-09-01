package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Producto;
import com.example.demo.service.IProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService productoService;
	
	@PostMapping("/crearproducto")
	public String crearProducto(Producto producto) {
		
		this.productoService.crear(producto);
		
		return "redirect:/productos/nuevoproducto";
	}
	
	
	@GetMapping("/nuevoproducto")
	public String nuevoProducto(Producto producto) {
		
		return "vistaNuevoProducto";
	}
}
