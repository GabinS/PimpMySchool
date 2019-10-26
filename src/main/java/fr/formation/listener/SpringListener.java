package fr.formation.listener;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import fr.formation.dao.IDAOFormation;
import fr.formation.dao.IDAOMatiere;
import fr.formation.dao.IDAOSalle;
import fr.formation.dao.IDAOUniteEnseignement;
import fr.formation.model.Matiere;
import fr.formation.model.Salle;
import fr.formation.model.UniteEnseignement;
import fr.formation.model.Formation;

@Component
public class SpringListener {
	
	@Autowired
	private IDAOMatiere daoMatiere;  
  
	@Autowired
	private IDAOUniteEnseignement daoUniteEnseignement;
	
	@Autowired
	private IDAOSalle daoSalle;
	
		
	@Autowired
	private IDAOFormation daoFormation;
	
	@EventListener(ContextRefreshedEvent.class)
	@Transactional
	public void handleContextStarted() {		
		// Initialisation matiere
		Matiere m = new Matiere("JEE", "objectifs JEE", "prerequis JEE", "contenu JEE");
		Matiere m2 = new Matiere("C#", "objectifs C#", "prerequis C#", "contenu C#");

		//Initialisation UniteEnseignement
		UniteEnseignement ue = new UniteEnseignement("Conception et Développement du Logiciel");
		ue.addMatiere(m);
		ue.addMatiere(m2);
		daoUniteEnseignement.save(ue);
  
  	// Initialisation formation
		Formation f1 = new Formation();
		f1.setLibelle("Master I");
		Formation f2 = new Formation();
		f2.setLibelle("Licence Info Dev");
		System.out.println( daoFormation.save(f1).getId());
		daoFormation.save(f2);

		// Initialisation Salle
		Salle s1 = new Salle(50, "92 rue des singes", "diddy.kong@banana.com");
		Salle s2 = new Salle(25, "25 avenue Mouche", "Damine.L@mail.com");
		daoSalle.save(s1);
		daoSalle.save(s2);
	}
}
