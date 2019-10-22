package fr.formation.dao.jpa;

import fr.formation.dao.IDAOGestionnaire;
import fr.formation.model.Gestionnaire;

public abstract class DAOGestionnaireJpa extends DAOJpa<Gestionnaire> implements IDAOGestionnaire{
public DAOGestionnaireJpa() {
		this._Class = Gestionnaire.class;
	}
}