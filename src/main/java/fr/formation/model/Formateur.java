package fr.formation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "formateur")
@PrimaryKeyJoinColumn(name = "FOR_ID", referencedColumnName = "RH_ID")
public class Formateur extends RessourceHumaine{
	
	@ManyToMany(mappedBy = "listFormateur")
	private List<UniteEnseignement> listUniteEnseignement;
	
	@OneToMany(mappedBy = "formateur")
	private List<Matiere> listMatiere;
	
	@OneToMany(mappedBy = "formateur")
	private List<Disponibilite> listDisponibilite;

	public List<UniteEnseignement> getListUniteEnseignement() {
		return listUniteEnseignement;
	}

	
	public Formateur() {
		
	}
	
	public void setListUniteEnseignement(List<UniteEnseignement> listUniteEnseignement) {
		this.listUniteEnseignement = listUniteEnseignement;
	}

	public List<Matiere> getListMatiere() {
		return listMatiere;
	}

	public void setListMatiere(List<Matiere> listMatiere) {
		this.listMatiere = listMatiere;
	}

	public List<Disponibilite> getListDisponibilite() {
		return listDisponibilite;
	}

	public void setListDisponibilite(List<Disponibilite> listDisponibilite) {
		this.listDisponibilite = listDisponibilite;
	}
	
	
}
