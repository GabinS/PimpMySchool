package fr.formation.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAOGestionnaire;
import fr.formation.model.Gestionnaire;

@Repository
public class DAOGestionnaireJpa extends DAOJpa<Gestionnaire> implements IDAOGestionnaire {
public DAOGestionnaireJpa() {
		this._Class = Gestionnaire.class;
	}
}