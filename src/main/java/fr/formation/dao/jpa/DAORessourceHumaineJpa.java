package fr.formation.dao.jpa;

import fr.formation.model.RessourceHumaine;

public abstract class DAORessourceHumaineJpa extends DAOJpa<RessourceHumaine>{
	public DAORessourceHumaineJpa() {
		this._Class = RessourceHumaine.class;
	}
}