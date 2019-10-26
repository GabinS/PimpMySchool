package fr.formation.listener;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import fr.formation.dao.IDAOFormation;
import fr.formation.dao.IDAOMatiere;
import fr.formation.dao.IDAOSalle;
import fr.formation.model.Matiere;
import fr.formation.model.Salle;

@Component
public class SpringListener {
	
	@Autowired
	private IDAOMatiere daoMatiere;
	
	@Autowired
	private IDAOSalle daoSalle;
	
	//@Autowired
	private IDAOFormation daoFormation;
	
	@EventListener(ContextRefreshedEvent.class)
	@Transactional
	public void handleContextStarted() {		
		// Initialisation matiere
		Matiere m = new Matiere("JEE", "objectifs JEE", "prerequis JEE", "contenu JEE");
		daoMatiere.save(m);
		Matiere m2 = new Matiere("C#", "objectifs C#", "prerequis C#", "contenu C#");
		daoMatiere.save(m2);

		// Initialisation Salle
		Salle s1 = new Salle(50, "92 rue des singes", "diddy.kong@banana.com");
		Salle s2 = new Salle(25, "25 avenue Mouche", "bzz.bzz@bzzbzzbzz.bzz");
		daoSalle.save(s1);
		daoSalle.save(s2);
	}
}
