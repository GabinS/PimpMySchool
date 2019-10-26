package fr.formation.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAOStagiaire;
import fr.formation.model.Stagiaire;

@Repository
public class DAOStagiaireJpa extends DAOJpa<Stagiaire> implements IDAOStagiaire {
	public DAOStagiaireJpa() {
		this._Class = Stagiaire.class;
	}
}