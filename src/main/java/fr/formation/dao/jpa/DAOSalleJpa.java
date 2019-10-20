package fr.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAOSalle;
import fr.formation.model.Salle;

@Repository
public abstract class DAOSalleJpa implements IDAOSalle {
	@PersistenceContext
	private EntityManager em;

	public Salle findById(int id) {
		return em.find(Salle.class, id);
	}

	public List<Salle> findAll() {
		return em
				.createQuery("select s from Salle s", Salle.class)
				.getResultList();
	}

	public Salle save(Salle entity) {
		entity = em.merge(entity);
		em.persist(entity);
		return entity;
	}

	public void deleteById(int id) {
		em
		.createQuery("delete s from Salle where id = :id")
		.setParameter("id", id)
		.executeUpdate();
	}
}