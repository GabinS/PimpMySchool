package fr.formation.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.formation.model.RessourceHumaine;

@Repository
public abstract class DAORessourceHumaineJpa extends DAOJpa<RessourceHumaine>{
	public DAORessourceHumaineJpa() {
		this._Class = RessourceHumaine.class;
	}
}