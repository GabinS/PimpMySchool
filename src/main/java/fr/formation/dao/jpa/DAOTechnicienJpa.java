package fr.formation.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAOTechnicien;
import fr.formation.model.Technicien;

@Repository
public class DAOTechnicienJpa extends DAOJpa<Technicien> implements IDAOTechnicien {
	public DAOTechnicienJpa() {
		this._Class = Technicien.class;
	}
}