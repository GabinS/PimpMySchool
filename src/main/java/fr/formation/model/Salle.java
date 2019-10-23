package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="salle")
@PrimaryKeyJoinColumn(name = "SAL_ID", referencedColumnName = "RES_MAT_ID")
public class Salle extends RessourceMaterielle {

	//Fields	
	@Column(name="SAL_UMAX")
	private int utilisateurMax;

	@Column(name="SAL_ADR")
	private String adresse;
	
	@Column(name="SAL_CONTACT")
	private String contact;
	
	//Properties
	public int getNbMaxUser() {return utilisateurMax;}
	public void setNbMaxUser(int nbMaxUser) {this.utilisateurMax = nbMaxUser;}

	public String getAdresse() {return adresse;}
	public void setAdresse(String adresse) {this.adresse = adresse;}

	public String getContactAdministratif() {return contact;}
	public void setContactAdministratif(String contactAdministratif) {this.contact = contactAdministratif;}
	
	//Constructors
	public Salle() {}
	
	public Salle(int nbMaxUser) {
		super();
		this.utilisateurMax = nbMaxUser;
	}
	
	public Salle(int nbMaxUser, String adresse) {
		super();
		this.utilisateurMax = nbMaxUser;
		this.adresse = adresse;
	}
	
	public Salle(int nbMaxUser, String adresse, String contact) {
		super();
		this.utilisateurMax = nbMaxUser;
		this.adresse = adresse;
		this.contact = contact;
	}
}
