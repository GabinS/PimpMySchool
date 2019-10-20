package fr.formation.dao.jpa;

import fr.formation.dao.IDAORessourceMaterielle;
import fr.formation.model.RessourceMaterielle;

public abstract class DAORessourceMaterielleJpa extends DAOJpa<RessourceMaterielle> implements IDAORessourceMaterielle {
	public DAORessourceMaterielleJpa() {
		this._Class = RessourceMaterielle.class;
	}
}