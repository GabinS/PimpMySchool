package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="salle")
public class Salle extends RessourceMaterielle {

	//Fields
	@Column(name="SAL_MAXUSER")
	private int nbMaxUser;

	@Column(name="SAL_ADR")
	private String adresse;
	
	@Column(name="SAL_CONTACT")
	private String contactAdministratif;
	
	//TODO : Faire les jointures.
	
	//Properties
	public int getNbMaxUser() {return nbMaxUser;}
	public void setNbMaxUser(int nbMaxUser) {this.nbMaxUser = nbMaxUser;}

	public String getAdresse() {return adresse;}
	public void setAdresse(String adresse) {this.adresse = adresse;}

	public String getContactAdministratif() {return contactAdministratif;}
	public void setContactAdministratif(String contactAdministratif) {this.contactAdministratif = contactAdministratif;}
	
	//Constructors
	public Salle() {}
	
	//TODO : Ajouter des constructeurs
}
