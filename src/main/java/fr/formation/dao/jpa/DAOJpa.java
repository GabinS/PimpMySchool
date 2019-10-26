package fr.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public abstract class DAOJpa<T> {
	@PersistenceContext
	protected EntityManager em;
	
	protected Class<T> _Class;
	
	
	public DAOJpa() { }	
	
	public List<T> findAll() {
		return em.createQuery("select t from " + _Class.getName() + " t", _Class)
				.getResultList();
	}

	public T findById(int id) {
		return em.find(_Class, id);
	}

	public T save(T entity) {
		entity = em.merge(entity);
		em.persist(entity);
		return entity;
	}
	
	public void deleteById(int id) {
		em.createQuery("delete from " + _Class.getName() + " where id = :id")
			.setParameter("id", id)
			.executeUpdate();
	}
}