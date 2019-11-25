package fr.formation.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.model.Disponibilite;
import fr.formation.model.Ordinateur;
import fr.formation.service.DisponibiliteService;
import fr.formation.service.OrdinateurService;

@Controller
@RequestMapping(value = "/dispo")
public class OrdinateurDisponibiliteController {


	@Autowired
	private OrdinateurService srvOrdinateur;
	
	@Autowired
	private DisponibiliteService srvDispo;
	
	//La gestion des dispo a seulement associés aux ordinateur. De futurs développement permettraient de l'associer aux autres modules dont les ressources matérielles par exemple.
	
	@GetMapping("/ajouter/{ordiId}/{dataCorrect}")
	public String addDispo(Model model, @PathVariable int ordiId, @PathVariable Boolean dataCorrect) {

		if (!dataCorrect) {
			model.addAttribute("error", "Les dates renseignés ne sont pas valables. L'ordinateur est déjà réservé sur cette période");	
		}
		
		Ordinateur ordi = srvOrdinateur.get(ordiId);
		model.addAttribute("ordi", ordi);		
		return "ressourceMaterielle/formDisponibilite";
	}
	
	@PostMapping("/ajouter/{ordiId}/{dataCorrect}")
	public String addOrdinateurDispo(@ModelAttribute Disponibilite dispo, @PathVariable int ordiId, @PathVariable Boolean dataCorrect) {
 		Ordinateur ordi = srvOrdinateur.get(ordiId);

		List<Disponibilite> listDispo = ordi.getListDisponibilite();
		
		if (isDisponibiliteValid(listDispo, dispo, 0)) {
	
			Date d1 = dispo.getDateDebut();
			Date d2 = dispo.getDateFin();
			
			Disponibilite tempDispo = new Disponibilite(d1, d2);
				
			listDispo.add(tempDispo);
			
			tempDispo.setRessourceMaterielle(ordi);
			ordi.setListDisponibilite(listDispo);
			
	
			srvOrdinateur.add(ordi);
			
			
			//srvDispo.add(dispo);		
			return "redirect:/ordinateur";
		
		}else {
			return "redirect:/dispo/ajouter/" + ordiId + "/false";
		}
	}
	
	//Update
	@GetMapping("/modifier/{ordiId}/{dispoId}/{dataCorrect}")
	public String updateDispo(Model model, @PathVariable int ordiId, @PathVariable int dispoId, @PathVariable Boolean dataCorrect) {
		
		if (!dataCorrect) {
			model.addAttribute("error", "Les dates renseignés ne sont pas valables. L'ordinateur est déjà réservé sur cette période");	
		}
		
		Ordinateur ordi = srvOrdinateur.get(ordiId);
		Disponibilite dispo = srvDispo.get(dispoId);
		model.addAttribute("ordi", ordi);	
		model.addAttribute("dispo", dispo);	
		return "ressourceMaterielle/formDisponibilite";
	}
	
	@PostMapping("/modifier/{ordiId}/{dispoId}/{dataCorrect}")
	public String updateOrdinateurDispo(Model model, @ModelAttribute Disponibilite dispo, @PathVariable int ordiId, @PathVariable int dispoId, @PathVariable Boolean dataCorrect) {
		
		Ordinateur ordi = srvOrdinateur.get(ordiId);	

		List<Disponibilite> listDispo = ordi.getListDisponibilite();
		
		if (isDisponibiliteValid(listDispo, dispo, dispoId)) {
		
			Date dateDeb = dispo.getDateDebut();
			Date dateFin = dispo.getDateFin();
			
			int i = 0;		
			for (Disponibilite disponibilite : listDispo) {
				if (disponibilite.getId() == dispoId) {
					break;
				}
				i++;
			}
			
			Disponibilite oldDispo = listDispo.get(i);
	
			oldDispo.setDateDebut(dateDeb);
			oldDispo.setDateFin(dateFin);
			
			listDispo.set(i, oldDispo);
					
			srvDispo.update(oldDispo);
			srvOrdinateur.save(ordi);
					
			return "redirect:/ordinateur";
		
		}else {
			return "redirect:/dispo/modifier/" + ordiId + "/" + dispoId + "/false";
		}
	}
	
	@GetMapping("/supprimer/{ordiId}/{dispoId}")
	public String delete( @PathVariable int ordiId, @PathVariable int dispoId) {
		
		Ordinateur ordi = srvOrdinateur.get(ordiId);
		Disponibilite dispo = srvDispo.get(dispoId);
		List<Disponibilite> listDispo = ordi.getListDisponibilite();
		
		int i = 0;
		
		for (Disponibilite disponibilite : listDispo) {
			if (disponibilite.getId() == dispoId) {
				break;
			}
			i++;
		}
		
		listDispo.remove(i);
		ordi.setListDisponibilite(listDispo);
		
		srvOrdinateur.save(ordi);
		srvDispo.delete(dispoId);
		
		return "redirect:/ordinateur";
	}		
	
	/**
	 * Vérification si les dates de réservations ne se supperposent pas
	 * @param listDispo liste des disponibilitées pour l'ordinateur
	 * @param dispo disponibilité à checker
	 * @return true si aucun soucis et false si une annulation doit être faite. 
	 */
	public Boolean isDisponibiliteValid(List<Disponibilite> listDispo, Disponibilite dispo,  int idDispo) {
		
		boolean isAllRight = true;
		
		Date dateDebut = dispo.getDateDebut();
		Date dateFin = dispo.getDateFin();
		
		if(dispo.getDateDebut().compareTo(dispo.getDateFin()) <= 0) {
			for (Disponibilite disponibilite : listDispo) {
				
				if (disponibilite.getId() != idDispo) {
					
					Date dateDebutDispo = disponibilite.getDateDebut();
					Date dateFinDispo = disponibilite.getDateFin();
					
					if(!(dateFin.compareTo(dateDebutDispo) < 0) && !(dateDebut.compareTo(dateFinDispo) > 0)) {
						isAllRight = false;
					}	
				}		
			}
		}
		else {
			isAllRight = false;
		}
		
		return isAllRight;
		
	}
}
