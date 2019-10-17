package fr.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAOFormation;
import fr.formation.models.Formation;

@Repository
public abstract class DAOFormationJpa implements IDAOFormation{

	@PersistenceContext
	private EntityManager em;
	
	public Formation FindById(int id) {
		return em.find(Formation.class, id);
	}

	public List<Formation> FindAll() {
		return em.createQuery("select f from Formation f", Formation.class).getResultList();
	}

	@Transactional
	public Formation Save(Formation obj) {
		obj = em.merge(obj);
		em.persist(obj);
		return obj;
	}

	public void DeleteById(int id) {
		em.createQuery("delete from Formation where id = :id)")
				.setParameter("id", id)
				.executeUpdate();
	}
	
}