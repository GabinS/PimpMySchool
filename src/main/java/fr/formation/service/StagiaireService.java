package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.dao.IDAOStagiaire;
import fr.formation.model.Stagiaire;

@Service
public class StagiaireService {

	@Autowired(required = false)
	private IDAOStagiaire daoStagiaire;
	
	public List<Stagiaire> findAll() {
		return daoStagiaire.findAll();
	}
	
	public Stagiaire get(int id) {
		return daoStagiaire.findById(id);
	}

	@Transactional
	public Stagiaire add(Stagiaire stagiaire) {
		return daoStagiaire.save(stagiaire);
	}
	
	@Transactional
	public Stagiaire edit(Stagiaire stagiaire) {
		return daoStagiaire.save(stagiaire);
	}
	
	@Transactional
	public void deleteById(int id) {
		daoStagiaire.deleteById(id);
	}
	
	
}
