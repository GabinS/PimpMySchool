package fr.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="uniteEnseignement")
public class UniteEnseignement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UNI_ID", nullable = false)
	private int id;
	
	@Column(name="UNI_TITRE")
	private String titre;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="uniteEnseignementMatiere",
		joinColumns=@JoinColumn(name="UNI_ENS_MAT_ID", referencedColumnName="UNI_ID"),
		inverseJoinColumns=@JoinColumn(name="MAT_UNI_ENS_ID", referencedColumnName="MAT_ID")
	)
	private List<Matiere> listMatiere;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
		name="uniteEnseignementFormateur",
		joinColumns=@JoinColumn(name="UNI_ENS_FOR_ID", referencedColumnName="UNI_ID"),
		inverseJoinColumns=@JoinColumn(name="FOR_UNI_ENS_ID", referencedColumnName="FOR_ID")
	)
	private List<Formateur> listFormateur;
	
	public UniteEnseignement() {
		super();
	}
	
	public UniteEnseignement(String titre) {
		super();
		this.titre = titre;
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

	public List<Matiere> getListMatiere() {
		return listMatiere;
	}

	public void setListMatiere(List<Matiere> listMatiere) {
		this.listMatiere = listMatiere;
	}
	
	public void addMatiere(Matiere matiere) {
		if (this.listMatiere == null) {
			this.listMatiere = new ArrayList<Matiere>();
		}		
		this.listMatiere.add(matiere);
	}

	public List<Formateur> getListFormateur() {
		return listFormateur;
	}

	public void setListFormateur(List<Formateur> listFormateur) {
		this.listFormateur = listFormateur;
	}	
}
