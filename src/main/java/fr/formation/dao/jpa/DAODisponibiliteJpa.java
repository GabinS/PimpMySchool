package fr.formation.dao.jpa;

import fr.formation.dao.IDAODisponibilite;
import fr.formation.model.Disponibilite;

public abstract class DAODisponibiliteJpa extends DAOJpa<Disponibilite> implements IDAODisponibilite{
	public DAODisponibiliteJpa() {
		this._Class = Disponibilite.class;
	}
}