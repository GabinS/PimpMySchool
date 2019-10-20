package fr.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAOOrdinateur;
import fr.formation.model.Ordinateur;

@Repository
public abstract class DAOOrdinateurJpa implements IDAOOrdinateur{
	
	@PersistenceContext
	private EntityManager em;

	public Ordinateur FindById(int id) {
		return em.find(Ordinateur.class, id);
	}

	public List<Ordinateur> FindAll() {
		Query myQuery = em.createQuery("select m from Ordinateur m", Ordinateur.class);
		return myQuery.getResultList();
	}

	public Ordinateur Save(Ordinateur entity) {
		entity = em.merge(entity);
		em.persist(entity);
		return entity;
	}

	public void DeleteById(int id) {
		em.createQuery("delete from Ordinateur where id = :id").setParameter("id", id).executeUpdate();
	}
	
}