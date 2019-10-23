package fr.formation.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAORessourceMaterielle;
import fr.formation.model.RessourceMaterielle;

@Repository
public abstract class DAORessourceMaterielleJpa extends DAOJpa<RessourceMaterielle> implements IDAORessourceMaterielle {
	public DAORessourceMaterielleJpa() {
		this._Class = RessourceMaterielle.class;
	}
}