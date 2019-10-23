package fr.formation.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAOOrdinateur;
import fr.formation.model.Ordinateur;

@Repository
public abstract class DAOOrdinateurJpa extends DAOJpa<Ordinateur> implements IDAOOrdinateur{
	public DAOOrdinateurJpa() {
		this._Class = Ordinateur.class;
	}
	
}
