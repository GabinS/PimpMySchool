package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.dao.IDAORessourceHumaine;
import fr.formation.model.RessourceHumaine;

@Service
public class RessourceHumaineService {

	@Autowired
	private IDAORessourceHumaine daoRessourceHumaine;
	
	public List<RessourceHumaine> findAll() {
		return daoRessourceHumaine.findAll();
	}
	
	public RessourceHumaine get(int id) {
		return daoRessourceHumaine.findById(id);
	}

	@Transactional
	public RessourceHumaine add(RessourceHumaine ressource) {
		return daoRessourceHumaine.save(ressource);
	}
	
	@Transactional
	public void deleteById(int id) {
		daoRessourceHumaine.deleteById(id);
	}
	
}
