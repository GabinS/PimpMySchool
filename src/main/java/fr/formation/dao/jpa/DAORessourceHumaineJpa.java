package fr.formation.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAORessourceHumaine;
import fr.formation.model.RessourceHumaine;

@Repository
public class DAORessourceHumaineJpa extends DAOJpa<RessourceHumaine> implements IDAORessourceHumaine{
	
	public DAORessourceHumaineJpa() {
		this._Class = RessourceHumaine.class;
	}
	
}