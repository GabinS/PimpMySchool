package fr.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAOOrdinateur;
import fr.formation.model.Ordinateur;

@Repository
public abstract class DAOOrdinateurJpa extends DAOJpa<Ordinateur> implements IDAOOrdinateur{
	public DAOMatiereJpa() {
		this._Class = Ordinateur.class;
	}
	
}