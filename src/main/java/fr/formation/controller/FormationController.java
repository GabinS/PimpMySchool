package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.model.Formation;
import fr.formation.service.FormationService;

@Controller
public class FormationController {

	@Autowired
	private FormationService srvFormation;
	
	@GetMapping("formation")
	public String FormationGet(Model model) {
		
		Formation f = new Formation();
		f.setLibelle("Master II");
		
		model.addAttribute("formation", f);
		return "formation";
	}
}
