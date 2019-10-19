package fr.formation.dao.jpa;

import fr.formation.dao.IDAOUniteEnseignement;
import fr.formation.model.UniteEnseignement;

public abstract class DAOUniteEnseignementJpa extends DAOJpa<UniteEnseignement> implements IDAOUniteEnseignement{
	public DAOUniteEnseignementJpa() {
		this._Class = UniteEnseignement.class;
	}
}