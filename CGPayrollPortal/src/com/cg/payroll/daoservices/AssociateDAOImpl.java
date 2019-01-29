package com.cg.payroll.daoservices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.payroll.beans.Associate;

public class AssociateDAOImpl implements AssociateDAO {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");

	@Override
	public Associate save(Associate associate) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(associate);
		entityManager.getTransaction().commit();
		entityManager.close();
		return associate;
	}

	@Override
	public Associate update(Associate associate) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(associate);
		entityManager.getTransaction().commit();
		entityManager.close();
		return associate;
	}

	@Override
	public Associate findOne(int associateId) {
		return entityManagerFactory.createEntityManager().find(Associate.class, associateId);
	}

	@Override
	public List<Associate> findAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("from Associate a");
		return query.getResultList();
	}
}