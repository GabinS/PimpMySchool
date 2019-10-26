package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.service.FormationService;

@Controller
@RequestMapping(value = "/formation")
public class FormationController {

	@Autowired
	private FormationService srvFormation;
	
	@GetMapping("")
	public String FormationGet(Model model) { // Affiche la liste des formations
		
		model.addAttribute("formation", srvFormation.findAll().get(0));
		return "formation/formation";
	}
}
