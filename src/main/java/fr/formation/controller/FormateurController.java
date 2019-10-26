package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.service.FormateurService;

@Controller
@RequestMapping(value = "/formateur")
public class FormateurController {

	@Autowired
	private FormateurService srvFormateur;
	
	
}
