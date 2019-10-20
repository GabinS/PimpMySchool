package fr.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.formation.dao.IDAORessourceMaterielle;
import fr.formation.model.RessourceMaterielle;

public abstract class DAORessourceMaterielleJpa implements IDAORessourceMaterielle {
	@PersistenceContext
	private EntityManager em;
	
	public RessourceMaterielle findById(int id) {
		return em.find(RessourceMaterielle.class, id);
	}
	
	public List<RessourceMaterielle> findAll() {
		return em
				.createQuery("select r from RessourceMaterielle r", RessourceMaterielle.class)
				.getResultList();
	}
	
	public RessourceMaterielle save (RessourceMaterielle entity) {
		entity = em.merge(entity);
		em.persist(entity);
		return entity;
	}
	
	public void deleteById(int id) {
		em
		.createQuery("delete r from RessourceMaterielle where id = :id")
		.setParameter("id", id)
		.executeUpdate();
	}
}