package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.model.Gestionnaire;
import fr.formation.model.RessourceHumaine;
import fr.formation.service.GestionnaireService;
import fr.formation.service.RessourceHumaineService;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {
	
	// A remettre avec config de gestion de sécurité
	//@Autowired
	//private PasswordEncoder passwordEncoder;
	
	@Autowired
	private GestionnaireService gestServ;
	
	@GetMapping
	public String register() {
		return "register";
	}
	
	@PostMapping
	public String register(@ModelAttribute Gestionnaire user) {

		String result = "redirect:./login";

		if (user.getUsername().equals("") || user.getPassword().equals("")) {
			result = "/register";
		} else {
			Gestionnaire u = new Gestionnaire();
			u.setUsername(user.getUsername());
			u.setPassword(user.getPassword());
			//u.setPassword(passwordEncoder.encode(user.getPassword()));
			gestServ.add(u);
		}

		return result;
	}
	
}
