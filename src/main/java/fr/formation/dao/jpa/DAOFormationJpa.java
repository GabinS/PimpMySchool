package fr.formation.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAOFormation;
import fr.formation.model.Formation;

@Repository
public class DAOFormationJpa extends DAOJpa<Formation> implements IDAOFormation {

	public DAOFormationJpa() {
		this._Class = Formation.class;
	}

	public Formation findByLibelle(String libelle) {
		try {
			return em
					.createQuery("select l from Formation l where l.libelle = :libelle", Formation.class)
					.setParameter("libelle", libelle)
					.getSingleResult();
		}
		catch(Exception e) {
			return null;
		}
	}
}