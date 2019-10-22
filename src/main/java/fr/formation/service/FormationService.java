package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.dao.IDAOFormation;
import fr.formation.model.Formation;

@Service
public class FormationService {

	@Autowired
	private IDAOFormation daoFormation;
	
	public List<Formation> findAll() {
		return daoFormation.FindAll();
	}
	
	public Formation get(int id) {
		return daoFormation.FindById(id);
	}
	
	@Transactional
	public Formation add(Formation formation) {
		return daoFormation.Save(formation);
	}
	
	@Transactional
	public void deleteById(int id) {
		daoFormation.DeleteById(id);
	}
}