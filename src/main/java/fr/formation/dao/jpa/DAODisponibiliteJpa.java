package fr.formation.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAODisponibilite;
import fr.formation.model.Disponibilite;

@Repository
public abstract class DAODisponibiliteJpa extends DAOJpa<Disponibilite> implements IDAODisponibilite{
	public DAODisponibiliteJpa() {
		this._Class = Disponibilite.class;
	}
}