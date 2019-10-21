package fr.formation.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAOPlanning;
import fr.formation.model.Planning;

@Repository
public abstract class DAOPlanningJpa extends DAOJpa<Planning> implements IDAOPlanning{
	public DAOPlanningJpa() {
		this._Class = Planning.class;
	}
}