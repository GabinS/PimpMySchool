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
import javax.persistence.Table;

@Entity
@Table(name="uniteEnseignement")
public class UniteEnseignement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UNI_ID")
	private int id;
	
	@Column(name="UNI_TITRE")
	private String titre;
	
	@ManyToMany
	@JoinTable(
		name="uniteEnseignementMatiere",
		joinColumns=@JoinColumn(name="UNI_ENS_MAT_ID", referencedColumnName="UNI_ID"),
		inverseJoinColumns=@JoinColumn(name="MAT_UNI_ENS_ID", referencedColumnName="MAT_ID")
	)
	private List<Matiere> listMatiere;
	
	@ManyToMany
	@JoinTable(
		name="uniteEnseignementMatiere",
		joinColumns=@JoinColumn(name="UNI_ENS_FOR_ID", referencedColumnName="UNI_ID"),
		inverseJoinColumns=@JoinColumn(name="FOR_UNI_ENS_ID", referencedColumnName="FOR_ID")
	)
	private List<Formateur> listFormateur;
	
	public UniteEnseignement() {
		super();
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

	public List<Formateur> getListFormateur() {
		return listFormateur;
	}

	public void setListFormateur(List<Formateur> listFormateur) {
		this.listFormateur = listFormateur;
	}	
}
