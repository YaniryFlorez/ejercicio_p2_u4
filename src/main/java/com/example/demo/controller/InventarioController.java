package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Inventario;
import com.example.demo.service.IInventarioService;

@Controller
@RequestMapping("/inventarios")
public class InventarioController {

	@Autowired
	private IInventarioService inventarioService;
	
	@PostMapping("/crearinventario")
	public String crearInventario(Inventario inventario) {
		this.inventarioService.crearInventario(inventario.getBodega().getNumero(), inventario.getProducto().getCodigoBarrasMaestro(), inventario.getCantidad());
		return "redirect:/inventarios/nuevoinventario";
	}
	
	
	@GetMapping("/nuevoinventario")
	public String nuevoInventario(Inventario inventario) {
		
		return "vistaNuevoInventario";
	}
}
