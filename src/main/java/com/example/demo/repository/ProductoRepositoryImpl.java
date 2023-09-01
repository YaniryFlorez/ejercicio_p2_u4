package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(value = TxType.MANDATORY)
	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Transactional(value = TxType.NOT_SUPPORTED)
	@Override
	public Producto buscarPorCodigoBarras(String codigoBarras) {
		TypedQuery<Producto> myQuery = this.entityManager.createQuery(
				"SELECT p FROM Producto p WHERE p.codigoBarrasMaestro=:datoCodigoBarrasMaestro", Producto.class);
		myQuery.setParameter("datoCodigoBarrasMaestro", codigoBarras);

		try {

			return myQuery.getSingleResult();

		} catch (Exception e) {

			// TODO: handle exception

			return null;

		}

	}

	@Transactional(value = TxType.MANDATORY)
	@Override
	public Integer actualizarStock(Integer id, Integer stock) {

		Query myQuery = this.entityManager.createQuery("UPDATE Producto p SET p.stock=:datoStock WHERE p.id=:datoId ");

		        myQuery.setParameter("datoStock", stock);

		        myQuery.setParameter("datoId", id);

		        return myQuery.executeUpdate();
	}

}
