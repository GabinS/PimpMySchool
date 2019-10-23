package fr.formation.listener;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import fr.formation.dao.IDAOFormation;
import fr.formation.dao.IDAOMatiere;
import fr.formation.model.Formation;

@Component
public class SpringListener {
	
	@Autowired
	private IDAOMatiere daoMatiere;
	
	@Autowired
	private IDAOFormation daoFormation;
	
	@EventListener(ContextRefreshedEvent.class)
	@Transactional
	public void handleContextStarted() {

	}
}
