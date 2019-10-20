package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.dao.IDAOUniteEnseignement;
import fr.formation.model.Matiere;
import fr.formation.model.UniteEnseignement;

@Service
public class UniteEnseignementService {
	
	@Autowired
	private IDAOUniteEnseignement daoUniteEnseignement;
	
	public List<UniteEnseignement> findAll() {
		return daoUniteEnseignement.FindAll();
	}
	
	public UniteEnseignement get(int id) {
		return daoUniteEnseignement.FindById(id);
	}
	
	@Transactional
	public UniteEnseignement add(UniteEnseignement uniteEnseignement) {
		return daoUniteEnseignement.Save(uniteEnseignement);
	}
		
	@Transactional
	public void deleteById(int id) {
		daoUniteEnseignement.DeleteById(id);
	}
	
}
