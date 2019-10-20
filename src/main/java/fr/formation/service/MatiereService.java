package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.dao.IDAOMatiere;
import fr.formation.model.Matiere;

@Service
public class MatiereService {
	
	@Autowired
	private IDAOMatiere daoMatiere;
	
	public List<Matiere> findAll() {
		return daoMatiere.FindAll();
	}
	
	public Matiere get(int id) {
		return daoMatiere.FindById(id);
	}
	
	@Transactional
	public Matiere add(Matiere matiere) {
		return daoMatiere.Save(matiere);
	}
		
	@Transactional
	public void deleteById(int id) {
		daoMatiere.DeleteById(id);
	}
}
