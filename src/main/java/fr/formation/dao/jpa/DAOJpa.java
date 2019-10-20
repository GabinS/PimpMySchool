package fr.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.core.GenericTypeResolver;


public abstract class DAOJpa<T> {
	@PersistenceContext
	protected EntityManager em;
	
	protected Class<T> _Class;
	
	@SuppressWarnings("unchecked")
	public DAOJpa() {
		_Class = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), DAOJpa.class);
	}	
	
	public List<T> FindAll() {
		return em.createQuery("select t from " + _Class.getName() + " t", _Class)
				.getResultList();
	}

	public T FindById(int id) {
		return em.find(_Class, id);
	}

	public T Save(T entity) {
		return em.merge(entity);
	}
	
	public void DeleteById(int id) {
		em.createQuery("delete from " + _Class.getName() + " where id = :id")
			.setParameter("id", id)
			.executeUpdate();
	}
}