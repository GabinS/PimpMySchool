package fr.formation.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAOVideoProjecteur;
import fr.formation.model.VideoProjecteur;

@Repository
public class DAOVideoProjecteurJpa extends DAOJpa<VideoProjecteur> implements IDAOVideoProjecteur {
	public DAOVideoProjecteurJpa() {
		this._Class = VideoProjecteur.class;
	}	
}