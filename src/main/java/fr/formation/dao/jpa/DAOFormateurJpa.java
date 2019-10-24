package fr.formation.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAOFormateur;
import fr.formation.model.Formateur;

@Repository
public abstract class DAOFormateurJpa extends DAOJpa<Formateur> implements IDAOFormateur{
	public DAOFormateurJpa() {
		this._Class = Formateur.class;
	}
}