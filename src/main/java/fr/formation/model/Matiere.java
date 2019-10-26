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
@Table(name="matiere")
public class Matiere {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MAT_ID", nullable = false)
	private int id;
	
	@Column(name="MAT_TITRE")
	private String titre;
	
	@Column(name="MAT_OBJECTIFS")
	private String objectifs;
	
	@Column(name="MAT_PREREQUIS")
	private String prerequis;
	
	@Column(name="MAT_CONTENU")
	private String contenu;
	
	@ManyToOne
	@JoinColumn(name="MAT_FORMATEUR_ID")
	private Formateur formateur;
	
	@ManyToMany(mappedBy = "listMatiere")
	private List<UniteEnseignement> listUniteEnseignement;

	@ManyToMany
	@JoinTable(
		name="matiereFormation",
		joinColumns=@JoinColumn(name="MAT_FOR_ID", referencedColumnName="MAT_ID"),
		inverseJoinColumns=@JoinColumn(name="FOR_MAT_ID", referencedColumnName="FOR_ID")
	)
	private List<Formation> listFormation;

	@OneToMany(mappedBy = "matiere")
	private List<Planning> listPlanning;
	
	public Matiere() {
		super();
	}
	
	public Matiere(String titre, String objectifs, String prerequis, String contenu) {
		super();
		this.titre = titre;
		this.objectifs = objectifs;
		this.prerequis = prerequis;
		this.contenu = contenu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(String objectifs) {
		this.objectifs = objectifs;
	}

	public String getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public List<UniteEnseignement> getUniteEnseignement() {
		return listUniteEnseignement;
	}

	public void setUniteEnseignement(List<UniteEnseignement> uniteEnseignement) {
		this.listUniteEnseignement = uniteEnseignement;
	}

	public List<Formation> getListFormation() {
		return listFormation;
	}

	public void setListFormation(List<Formation> listFormation) {
		this.listFormation = listFormation;
	}

	public List<Planning> getListPlanning() {
		return listPlanning;
	}

	public void setListPlanning(List<Planning> listPlanning) {
		this.listPlanning = listPlanning;
	}	
}
