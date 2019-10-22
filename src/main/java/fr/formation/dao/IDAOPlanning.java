package fr.formation.dao;

import java.util.List;

import fr.formation.model.Planning;

public interface IDAOPlanning extends IDAO<Planning>{

	List<Planning> findAll();

	public void save(Planning p);

	public void deleteById(int id);

}
