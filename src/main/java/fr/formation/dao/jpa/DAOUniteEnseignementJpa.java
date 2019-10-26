package fr.formation.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAOUniteEnseignement;
import fr.formation.model.UniteEnseignement;

@Repository
public class DAOUniteEnseignementJpa extends DAOJpa<UniteEnseignement> implements IDAOUniteEnseignement {
	public DAOUniteEnseignementJpa() {
		this._Class = UniteEnseignement.class;
	}
}