package fr.formation.dao.jpa;

import fr.formation.dao.IDAOTechnicien;
import fr.formation.model.Technicien;

public abstract class DAOTechnicienJpa extends DAOJpa<Technicien> implements IDAOTechnicien{
	public DAOTechnicienJpa() {
		this._Class = Technicien.class;
	}
}