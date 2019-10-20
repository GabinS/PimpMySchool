package fr.formation.dao.jpa;

import fr.formation.dao.IDAOMatiere;
import fr.formation.model.Matiere;

public abstract class DAOMatiereJpa extends DAOJpa<Matiere> implements IDAOMatiere {
	public DAOMatiereJpa() {
		this._Class = Matiere.class;
	}
	
}