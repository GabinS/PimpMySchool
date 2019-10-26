package fr.formation.controller;

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

@Controller
@RequestMapping(value = "/formation")
public class FormationController {

	@Autowired
	private FormationService srvFormation;
	
	private String list= "listFormation";
	private String form= "formationForm";
	
	@GetMapping("")
	public String FormationGet(Model model) { // Affiche la liste des formations
		model.addAttribute("listFormation", srvFormation.findAll());
		
		model.addAttribute("title", "Formation");
		model.addAttribute("list", this.list);
		model.addAttribute("form", "descriptionFormation");
		return "formation/formationTemplate";
	}
	
	@GetMapping("/add")
	public String CreateFormationGet(Model model) {
		model.addAttribute("listFormation", srvFormation.findAll());
		
		model.addAttribute("title", "Nouvelle formation");
		model.addAttribute("list", this.list);
		model.addAttribute("form", this.form);
		return "formation/formationTemplate";
	}
	
	@GetMapping("/edit/{id}")
	public String EditFormationGet(Model model, @PathVariable int id) {
		Formation formation = srvFormation.get(id);
		model.addAttribute("formation", formation);
		
		model.addAttribute("listFormation", srvFormation.findAll());
		
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
