package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.dao.IDAOGestionnaire;
import fr.formation.model.Gestionnaire;

@Service
public class GestionnaireService {

	@Autowired(required = false)
	private IDAOGestionnaire daoGestionnaire;
	
	public List<Gestionnaire> findAll() {
		return daoGestionnaire.findAll();
	}
	
	public Gestionnaire get(int id) {
		return daoGestionnaire.findById(id);
	}

	@Transactional
	public Gestionnaire add(Gestionnaire gestionnaire) {
		return daoGestionnaire.save(gestionnaire);
	}
	
	@Transactional
	public Gestionnaire edit(Gestionnaire gestionnaire) {
		return daoGestionnaire.save(gestionnaire);
	}
	
	@Transactional
	public void deleteById(int id) {
		daoGestionnaire.deleteById(id);
	}
	
}
