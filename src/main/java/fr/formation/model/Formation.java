package fr.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	// TODO Surement a modif
	@ManyToMany
	@JoinTable(name = "matos")
	private List<RessourceMaterielle> listRessourceMaterielle;

	// TODO Remplir le mappedBy par le nom de la variable dans la classe Stagiaire
	@OneToMany(mappedBy = "")
	private List<Stagiaire> listStagiaire;

	// TODO Remplir le mappedBy par le nom de la variable dans la classe Planning
	@OneToMany(mappedBy = "")
	private List<Planning> planningFormation;

	//TODO Compléter 'name' du JoinColumn
	@ManyToOne()
	@JoinColumn(name = "")
	private Gestionnaire gestionnaire;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


// --------------------------------------------------------
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


// --------------------------------------------------------
	public List<Matiere> getListMatiere() {
		return listMatiere;
	}

	public void setListMatiere(List<Matiere> listMatiere) {
		this.listMatiere = listMatiere;
	}


// --------------------------------------------------------
	public List<Stagiaire> getListStagiaire() {
		return listStagiaire;
	}

	public void setListStagiaire(List<Stagiaire> listStagiaire) {
		this.listStagiaire = listStagiaire;
	}

	public boolean addStagiaire(Stagiaire s) {
		if(listStagiaire.add(s))
			return true;
		return false;
	}
	
// --------------------------------------------------------

	public List<Planning> getPlanningFormation() {
		return planningFormation;
	}

	public void setPlanningFormation(List<Planning> planningFormation) {

		this.planningFormation = planningFormation;
	}

// --------------------------------------------------------
	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}
// --------------------------------------------------------

}
