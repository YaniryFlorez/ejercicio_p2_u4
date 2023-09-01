package com.example.demo.repository;

import com.example.demo.repository.modelo.Bodega;

public interface IBodegaRepository {

	public void insertar(Bodega bodega);
	public Bodega buscarPorNumero(String numero);
	
	
}
