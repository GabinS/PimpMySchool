package fr.formation.dao.jpa;

import fr.formation.dao.IDAOVideoProjecteur;
import fr.formation.model.VideoProjecteur;

public abstract class DAOVideoProjecteurJpa extends DAOJpa<VideoProjecteur> implements IDAOVideoProjecteur{
	public DAOVideoProjecteurJpa() {
		this._Class = VideoProjecteur.class;
	}
	
}