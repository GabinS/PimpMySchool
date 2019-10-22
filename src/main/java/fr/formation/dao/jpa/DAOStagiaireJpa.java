package fr.formation.dao.jpa;

import fr.formation.dao.IDAOStagiaire;
import fr.formation.model.Stagiaire;

public abstract class DAOStagiaireJpa extends DAOJpa<Stagiaire> implements IDAOStagiaire{
	public DAOStagiaireJpa() {
		this._Class = Stagiaire.class;
	}
}