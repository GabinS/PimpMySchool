package fr.formation.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "formation")
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FOR_ID")
	private int id;
	
	@Column(name = "FOR_LIBELLE", length = 50, nullable = false)
	private String libelle;
	
	@ManyToMany(mappedBy = "listFormation")
	private List<Matiere> listMatiere;
	
	//TODO Surement a modif
	@ManyToMany
	@JoinTable(name = "matos")
	private List<RessourceMaterielle> matos;
	
	@OneToMany(mappedBy = "formation")
	private List<Stagiaire> listStagiaire;
	
	//TODO Completer le OneToOne
	@OneToOne()
	private Planning planningFormation;
	
	@ManyToOne()
	private Gestionnaire gestionnaire;
	
}
