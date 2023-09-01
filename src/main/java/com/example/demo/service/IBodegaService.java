package com.example.demo.service;

import com.example.demo.repository.modelo.Bodega;

public interface IBodegaService {

	public void ingresar(Bodega bodega);
	public Bodega buscarPorNumero(String numero);
	
}
