package fr.formation.controller;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.model.Formation;
import fr.formation.model.Matiere;
import fr.formation.service.FormationService;
import fr.formation.service.GestionnaireService;
import fr.formation.service.MatiereService;

@Controller
@RequestMapping(value = "/formation")
public class FormationController {

	@Autowired
	private FormationService srvFormation;
	
	@Autowired
	private GestionnaireService srvGestionnaire;
	
	@Autowired
	private MatiereService srvMatiere;
	
	private String list= "listFormation";
	private String form= "formationForm";
	
	private void AddData(Model model, int id) {
		model.addAttribute("listFormation", srvFormation.findAll());
		model.addAttribute("listGestionnaire", srvGestionnaire.findAll());
		model.addAttribute("listMatiere", srvMatiere.findAll());
		
		if(id > -1) {
			Formation formation = srvFormation.get(id);
			model.addAttribute("formation", formation);
		}
	}
	
	
	@GetMapping("")
	public String FormationGet(Model model) { // Affiche la liste des formations
		this.AddData(model, -1);
		
		model.addAttribute("title", "Formation");
		model.addAttribute("list", this.list);
		model.addAttribute("form", "descriptionFormation");
		return "formation/formationTemplate";
	}
	
	@GetMapping("/add")
	public String CreateFormationGet(Model model) {
		this.AddData(model, -1);
		
		model.addAttribute("title", "Nouvelle formation");
		model.addAttribute("list", this.list);
		model.addAttribute("form", this.form);
		return "formation/formationTemplate";
	}
	
	@GetMapping("/edit/{id}")
	public String EditFormationGet(Model model, @PathVariable int id) {		
		this.AddData(model, id);
		
		Formation formation = srvFormation.get(id);
		model.addAttribute("title", "Edition de la formation " + formation.getLibelle());
		model.addAttribute("list", this.list);
		model.addAttribute("form", this.form);
		return "formation/formationTemplate";
	}
	
	@GetMapping("/delete/{id}")
	public String DeleteFormationGet(Model model, @PathVariable int id) {
		srvFormation.deleteById(id);
		return "redirect:/formation";
	}
	
	
	@PostMapping("/add")
	public String CreateFormationPost(@ModelAttribute Formation formation) {
		srvFormation.add(formation);
		return "redirect:/formation";
	}
	
	@PostMapping("/edit/{id}")
	public String EditFormationPost(Model model, @ModelAttribute Formation formation) {
		srvFormation.add(formation);
		return "redirect:/formation";
	}
	
	@PostMapping("/delete/{id}")
	public String DeleteFormationPost(@PathVariable int id) {
		
		return "redirect:/formation";
	}
}
