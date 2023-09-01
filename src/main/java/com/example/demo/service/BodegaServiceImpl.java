package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.IBodegaRepository;
import com.example.demo.repository.modelo.Bodega;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class BodegaServiceImpl implements IBodegaService{

	@Autowired
	private IBodegaRepository bodegaRepository;
	
	@Transactional( value = TxType.REQUIRED)
	@Override
	public void ingresar(Bodega bodega) {
		// TODO Auto-generated method stub
		this.bodegaRepository.insertar(bodega);
	}

	@Transactional(value = TxType.NOT_SUPPORTED)
	@Override
	public Bodega buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.bodegaRepository.buscarPorNumero(numero);
	}



}
