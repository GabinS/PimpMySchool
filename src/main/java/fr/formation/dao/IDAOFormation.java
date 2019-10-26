package fr.formation.dao;

import fr.formation.model.Formation;

public interface IDAOFormation extends IDAO<Formation>{
	public Formation findByLibelle(String libelle);
}
