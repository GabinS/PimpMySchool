package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.model.UniteEnseignement;
import fr.formation.service.FormateurService;
import fr.formation.service.MatiereService;
import fr.formation.service.UniteEnseignementService;

@Controller
@RequestMapping(value = "/formation/ue")
public class UniteEnseignementController {
	
	@Autowired
	private UniteEnseignementService srvUniteEnseignementService;
	
	@Autowired
	private MatiereService srvMatiere;

	@Autowired
	private FormateurService srvFormateur;
	
	private String list = "listUE";
	private String form = "UEForm";
	
	@GetMapping("")
	public String UE(Model model) {
		model.addAttribute("listUE", srvUniteEnseignementService.findAll());
		
		model.addAttribute("title", "Unité d'enseignement");
		model.addAttribute("list", this.list);
		model.addAttribute("form", "descriptionUE");
		return "formation/formationTemplate";
	}
	
	@GetMapping("/add")
	public String CreateUEGet(Model model) {
		model.addAttribute("listUE", srvUniteEnseignementService.findAll());
		model.addAttribute("listMatiere", srvMatiere.findAll());
		model.addAttribute("listFormateur", srvFormateur.findAll());
		
		model.addAttribute("title", "Nouvelle Unité d'enseignement");
		model.addAttribute("list", this.list);
		model.addAttribute("form", this.form);
		return "formation/formationTemplate";
	}
	
	@GetMapping("/edit/{id}")
	public String EditUEGet(Model model, @PathVariable int id) {
		UniteEnseignement ue = srvUniteEnseignementService.get(id);
		if (ue != null) {
			model.addAttribute("uniteEnseignement", ue);

			model.addAttribute("listUE", srvUniteEnseignementService.findAll());
			model.addAttribute("listMatiere", srvMatiere.findAll());
			model.addAttribute("listFormateur", srvFormateur.findAll());	
			
			// pb de récupération (censé récupérer la liste des matières de l'ue)
			//model.addAttribute("listMatiere_UE", ue.getListMatiere());

			// pb de récupération (censé récupérer la liste des formateur de l'ue)
			//model.addAttribute("listFormateur_UE", ue.getListFormateur());					
			
			model.addAttribute("title", "Edition de l'Unité d'enseignement " + ue.getTitre());
			model.addAttribute("list", this.list);
			model.addAttribute("form", this.form);
			return "formation/formationTemplate";
		}
		return "redirect:/formation/ue";
	}
	
	@GetMapping("/delete/{id}")
	public String DeleteUEGet(Model model, @PathVariable int id) {
		srvUniteEnseignementService.deleteById(id);
		return "redirect:/formation/ue";
	}
	
	@PostMapping("/add")
	public String CreateUEPost(@ModelAttribute UniteEnseignement ue) {
		srvUniteEnseignementService.add(ue);
		return "redirect:/formation/ue";
	}
	
	@PostMapping("/edit/{id}")
	public String EditUEPost(Model model, @ModelAttribute UniteEnseignement ue) {
		srvUniteEnseignementService.edit(ue);
		return "redirect:/formation/ue";
	}
	
}
