package fr.formation.listener;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import fr.formation.dao.IDAOFormation;
import fr.formation.dao.IDAOGestionnaire;
import fr.formation.dao.IDAOMatiere;
import fr.formation.model.Formation;
import fr.formation.model.Gestionnaire;
import fr.formation.model.Matiere;

@Component
public class SpringListener {
	
	@Autowired
	private IDAOMatiere daoMatiere;
	
	@Autowired
	private IDAOFormation daoFormation;
	
	@Autowired
	private IDAOGestionnaire daoGestionnaire;
	
	@EventListener(ContextRefreshedEvent.class)
	@Transactional
	public void handleContextStarted() {		
		// Initialisation matiere
		Matiere m = new Matiere("JEE", "objectifs JEE", "prerequis JEE", "contenu JEE");
		daoMatiere.save(m);
		Matiere m2 = new Matiere("C#", "objectifs C#", "prerequis C#", "contenu C#");
		daoMatiere.save(m2);
		
		// Initialisation formation
		Formation f1 = new Formation();
		f1.setLibelle("Master I");
		//f1.addMatiere(m);
		Formation f2 = new Formation();
		f2.setLibelle("Licence Info Dev");
		System.out.println( daoFormation.save(f1).getId());
		daoFormation.save(f2);
		
		// Initialisation gestionnaire
		Gestionnaire g = new Gestionnaire();
		g.setUsername("Mr.Gestion");
		g.setPassword("password");
		daoGestionnaire.save(g);

	}
}
