package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Bodega;
import com.example.demo.service.IBodegaService;

@Controller
@RequestMapping("/bodegas")
public class BodegaCotroller {

	@Autowired
	private IBodegaService bodegaService;
	
	//capacidades 
	@PostMapping("/crearbodega")
	public String crearBodega(Bodega bodega){
		this.bodegaService.ingresar(bodega);
		
		return "redirect:/bodegas/nuevabodega";
	}
	
	//medodos de redireccionamiento
	
	//http://localhost:8080/bodegas/nuevabodega
	@GetMapping("/nuevabodega")
	public String nuevaBodega(Bodega bodega) {
		
		return "vistaNuevaBodega";
	}
	
}
