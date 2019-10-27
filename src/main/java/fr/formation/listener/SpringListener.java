package fr.formation.listener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import fr.formation.dao.IDAOFormateur;
import fr.formation.dao.IDAOFormation;
import fr.formation.dao.IDAOMatiere;
import fr.formation.dao.IDAOOrdinateur;
import fr.formation.dao.IDAOPlanning;
import fr.formation.dao.IDAOSalle;
import fr.formation.dao.IDAOUniteEnseignement;
import fr.formation.model.Disponibilite;
import fr.formation.model.Formateur;
import fr.formation.model.Formation;
import fr.formation.model.Matiere;
import fr.formation.model.Ordinateur;
import fr.formation.model.Salle;
import fr.formation.model.UniteEnseignement;

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
	
	@Autowired
	private IDAOPlanning daoPlanning;
	
	@Autowired
	private IDAOOrdinateur daoOrdinateur;
	
	@EventListener(ContextRefreshedEvent.class)
	@Transactional
	public void handleContextStarted() throws ParseException {		
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
		
		// Initialisation Planning	
		//Date d1 = new Date();
		//Date d2 = new Date();
		//Planning p1 = new Planning(1, d1, d2, m2, f2);
		//daoPlanning.save(p1);
		
		// Initialisation Ordinateurs
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = "2018-03-17";
		String date2 = "2019-05-25";
		
		String datedispo1 = "1999-03-17";
		String datedispo2 = "2000-05-25";
		
		String datedispo3 = "2001-03-17";
		String datedispo4 = "2002-05-25";
		
		Ordinateur o1 = new Ordinateur(
				"Intel Core i7-3770 3.40 GHz"
				, "8Go RAM DDR3"
				, "500Go HDD"
				, dateFormat.parse(date1)
				, "DELL OPTIPLEX 7010 SFF - WINDOWS 10");
		
		Ordinateur o2 = new Ordinateur(
				"Intel Core i5-9400F"
				, "RAM 16Go"
				, "HDD 1To + SSD 128Go"
				, dateFormat.parse(date2)
				, "HP PC Bureau Gamer OMEN Obelisk 875-0183nf");
		
		Disponibilite dispo1 = new Disponibilite(dateFormat.parse(datedispo1), dateFormat.parse(datedispo2));
		Disponibilite dispo2 = new Disponibilite(dateFormat.parse(datedispo3), dateFormat.parse(datedispo4));
		
		List<Disponibilite> listDispo1 = new ArrayList<Disponibilite>();
		listDispo1.add(dispo1);
		
		List<Disponibilite> listDispo2 = new ArrayList<Disponibilite>();
		listDispo2.add(dispo2);
		
		o1.setListDisponibilite(listDispo1);
		o2.setListDisponibilite(listDispo2);

		daoOrdinateur.save(o1);
		daoOrdinateur.save(o2);
		
		Formateur fo = new Formateur();
		fo.setUsername("test");
		fo.setPassword("test");
		fo.setPrenom("Jean");
		
	}
}
