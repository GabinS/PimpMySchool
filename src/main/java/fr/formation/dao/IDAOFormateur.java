package fr.formation.dao;

import fr.formation.model.Formateur;

public interface IDAOFormateur extends IDAO<Formateur>{
	public Formateur findUFormateur(String username);
}
