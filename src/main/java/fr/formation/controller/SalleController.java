package fr.formation.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.formation.dao.IDAOSalle;
import fr.formation.model.Disponibilite;
import fr.formation.model.Formation;
import fr.formation.model.Salle;
import fr.formation.service.FormationService;
import fr.formation.service.SalleService;

@Controller
public class SalleController {
	
	@Autowired
	private SalleService serviceSalle;
	
	@Autowired
	private FormationService serviceFormation;
	
	@Autowired
	private IDAOSalle daoSalle;
	
	@GetMapping("/salle")
	public String vue(Model model) {
		List<Salle> listSalle = serviceSalle.findAll();
		model.addAttribute("listSalle", listSalle);
		
		return "ressourceMaterielle/salle";
	}
	
	@GetMapping("/salle/ajouter")
	public String ajouter() {
		return "ressourceMaterielle/formSalle";
	}
	
	@PostMapping("/salle/ajouter")
	public String ajouterSalle(@ModelAttribute Salle salle) {
		serviceSalle.add(salle);
		
		return "redirect:/salle";
	}
	
	@GetMapping("/salle/modifier/{id}")
	public String modifier(Model model, @PathVariable int id) {
		Salle s = serviceSalle.get(id);
		model.addAttribute("salle", s);
		
		return "ressourceMaterielle/formSalle";
	}
	
	@PostMapping("/salle/modifier/{id}")
	public String modifierSalle(@ModelAttribute Salle salle) {
		serviceSalle.add(salle);
		
		return "redirect:/salle";
	}
	
	@GetMapping("/salle/supprimer/{id}")
	public String supprimer(Model model, @PathVariable int id) {
		serviceSalle.delete(id);
		
		return "redirect:/salle";
	}
	
	@GetMapping("/salle/reserver/{id}")
	public String reserver(Model model, @PathVariable int id) {
		Salle s = serviceSalle.get(id);
		model.addAttribute("salle", s);
		
		List<Formation> listFormation = serviceFormation.findAll();
		model.addAttribute("listFormation", listFormation);
		
		// Problème lors de la récupération de la liste, impossible de la traiter après.
		//List<Disponibilite> listDisponibilite = s.getListDisponibilite();
		//model.addAttribute("listDisponibilite", listDisponibilite);
		
		return "ressourceMaterielle/reserverSalle";
	}
	
	@PostMapping("/salle/reserver/{id}")
	public String reserverSalle(Model model, @PathVariable int id, @PathVariable Date dateDebut, @PathVariable Date dateFin, @PathVariable String libelle) {
		Salle s = serviceSalle.get(id);
		Formation f = serviceFormation.getByLibelle(libelle);
		//List<Disponibilite> listDisponibilite = serviceDisponibilite.findAll();
		boolean verify = true;
		
		// TODO : REMOVE
		Disponibilite d1 = new Disponibilite("25/10/2019", "30/10/2019");
		List<Disponibilite> listDisponibilite = new ArrayList<Disponibilite>();
		listDisponibilite.add(d1);
		
		if(dateDebut.compareTo(dateFin) <= 0) {
			for (Disponibilite disponibilite : listDisponibilite) {
				Date dateDebutDispo = disponibilite.getDateDebut();
				Date dateFinDispo = disponibilite.getDateFin();
				
				if((dateFin.compareTo(dateDebutDispo) < 0) && (dateDebut.compareTo(dateFinDispo) > 0)) {
					if(s.getUtilisateurMax() >= f.getListStagiaire().size()) {
						//Il n'y a pas de conflit avec les disponibilitéss existantes.
					}
					else {
						verify = false;
					}
				}
				else {
					verify = false;
				}
			}
		}
		else {
			verify = false;
		}
		
		if(verify == true) {
			Disponibilite d = new Disponibilite(dateDebut, dateFin);
			s.addDisponibilite(d);
			daoSalle.save(s);
			
			return "redirect:/salle";
		}
		else {
			String erreurMessage = "Votre demande ne correspond pas avec les réservations déjà existantes.";
			model.addAttribute("erreurMessage", erreurMessage);
			
			return "ressourceMaterielle/reserverSalle";
		}
	}
}
