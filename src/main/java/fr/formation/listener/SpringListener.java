package fr.formation.listener;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import fr.formation.dao.IDAOMatiere;
import fr.formation.model.Matiere;

@Component
public class SpringListener {
	
	@Autowired
	private IDAOMatiere daoMatiere;
	
	@EventListener(ContextRefreshedEvent.class)
	@Transactional
	public void handleContextStarted() {
		
//		//Initialisation d'une matiere
//		Matiere matiere = new Matiere();
//		matiere.setTitre("JEE");
//		matiere.setContenu("Le contenu JEE");
//		matiere.setPrerequis("Les prerequis JEE");
//		matiere.setObjectifs("Les objectifs JEE");
//		daoMatiere.Save(matiere);
		
	}
}
