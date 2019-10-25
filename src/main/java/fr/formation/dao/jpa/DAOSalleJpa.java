package fr.formation.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAOSalle;
import fr.formation.model.Salle;

@Repository
public class DAOSalleJpa extends DAOJpa<Salle> implements IDAOSalle {
	public DAOSalleJpa() {
		this._Class = Salle.class;
	}
}