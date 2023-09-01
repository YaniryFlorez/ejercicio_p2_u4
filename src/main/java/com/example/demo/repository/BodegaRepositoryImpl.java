package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Bodega;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class BodegaRepositoryImpl implements IBodegaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(value = TxType.MANDATORY)
	@Override
	public void insertar(Bodega bodega) {
		// TODO Auto-generated method stub
		this.entityManager.persist(bodega);

	}

	@Transactional(value = TxType.NOT_SUPPORTED)
	@Override
	public Bodega buscarPorNumero(String numero) {
		TypedQuery<Bodega> myQuery = this.entityManager.createQuery("SELECT b FROM Bodega b WHERE b.numero=:datoNumero",
				Bodega.class);
		myQuery.setParameter("datoNumero", numero);

		try {

			return myQuery.getSingleResult();

		} catch (Exception e) {

			// TODO: handle exception

			return null;

		}

	}

}
