package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.service.RessourceHumaineService;

@Controller
@RequestMapping(value = "/infos")
public class RessourceHumaineController {

	@Autowired
	private RessourceHumaineService srvRessourceHumaine;
	
	@GetMapping("/{id}")
	public String RessourceHumaine(@PathVariable int id, Model model) {
		
		model.addAttribute("ressourceHumaine", srvRessourceHumaine.get(id));
		return "/infos";
		
	}
	
}
