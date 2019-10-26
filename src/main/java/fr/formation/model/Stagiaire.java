package fr.formation.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "stagiaire")
@PrimaryKeyJoinColumn(name = "STA_ID", referencedColumnName = "RH_ID")
public class Stagiaire extends RessourceHumaine{
	
	@OneToOne
	@JoinColumn(name = "STA_ORDINATEUR_ID")
	private Ordinateur ordinateur;
	
	@ManyToOne
	@JoinColumn(name = "STA_FORMATION_ID")
	private Formation formation;

	public Stagiaire()
	{
		
	}	
		
	public Stagiaire(Ordinateur ordinateur, Formation formation) {
		super();
		this.ordinateur = ordinateur;
		this.formation = formation;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	
	
}
