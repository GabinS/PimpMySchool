package fr.formation.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAOFormation;
import fr.formation.model.Formation;

@Repository
public abstract class DAOFormationJpa extends DAOJpa<Formation> implements IDAOFormation{

	public DAOFormationJpa() {
		this._Class = Formation.class;
	}
	
}