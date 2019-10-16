package fr.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.core.GenericTypeResolver;


public abstract class DAOGestionnaireJpa<T> {
	@PersistenceContext
	protected EntityManager em;
	
	protected Class<T> _Class;
	
	@SuppressWarnings("unchecked")
	public DAOGestionnaireJpa() {
		_Class = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), DAOGestionnaireJpa.class);
	}	
	
	public List<T> findAll() {
		return em.createQuery("select t from " + _Class.getName() + " t", _Class)
				.getResultList();
	}

	public T findById(int id) {
		return em.find(_Class, id);
	}

	public T save(T entity) {
		return em.merge(entity);
	}
	
	public void deleteById(int id) {
		em.createQuery("delete from " + _Class.getName() + " where id = :id")
			.setParameter("id", id)
			.executeUpdate();
	}
}