package fr.formation.dao.jpa;

import fr.formation.dao.IDAOFormateur;
import fr.formation.model.Formateur;

public abstract class DAOFormateurJpa extends DAOJpa<Formateur> implements IDAOFormateur{
	public DAOFormateurJpa() {
		this._Class = Formateur.class;
	}
}