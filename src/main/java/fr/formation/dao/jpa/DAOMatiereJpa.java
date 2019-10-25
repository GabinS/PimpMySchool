package fr.formation.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAOMatiere;
import fr.formation.model.Matiere;

@Repository
public abstract class DAOMatiereJpa extends DAOJpa<Matiere> implements IDAOMatiere {	
	public DAOMatiereJpa() {
		this._Class = Matiere.class;
	}
}