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
	
	//TODO : Jointures.
	
	//Properties
	public int getNbMaxUser() {return nbMaxUser;}
	public void setNbMaxUser(int nbMaxUser) {this.nbMaxUser = nbMaxUser;}

	public String getAdresse() {return adresse;}
	public void setAdresse(String adresse) {this.adresse = adresse;}

	public String getContactAdministratif() {return contactAdministratif;}
	public void setContactAdministratif(String contactAdministratif) {this.contactAdministratif = contactAdministratif;}
	
	//Constructors
	public Salle() {}
	
	public Salle(int nbMaxUser) {
		super();
		this.nbMaxUser = nbMaxUser;
	}
	
	public Salle(int nbMaxUser, String adresse) {
		super();
		this.nbMaxUser = nbMaxUser;
		this.adresse = adresse;
	}
	
	public Salle(int nbMaxUser, String adresse, String contactAdministratif) {
		super();
		this.nbMaxUser = nbMaxUser;
		this.adresse = adresse;
		this.contactAdministratif = contactAdministratif;
	}
}
