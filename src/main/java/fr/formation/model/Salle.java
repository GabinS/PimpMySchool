package fr.formation.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="salle")
@PrimaryKeyJoinColumn(name = "SAL_ID", referencedColumnName = "RM_ID")
public class Salle extends RessourceMaterielle {

	//Fields	
	@Column(name="SAL_UMAX")
	private int utilisateurMax;

	@Column(name="SAL_ADR")
	private String adresse;
	
	@Column(name="SAL_CONTACT")
	private String contact;
	
	//Properties
	public int getUtilisateurMax() {return utilisateurMax;}
	public void setUtilisateurMax(int nbMaxUser) {this.utilisateurMax = nbMaxUser;}

	public String getAdresse() {return adresse;}
	public void setAdresse(String adresse) {this.adresse = adresse;}

	public String getContact() {return contact;}
	public void setContact(String contactAdministratif) {this.contact = contactAdministratif;}
	
	//Constructors
	public Salle() {}
	
	public Salle(int utilisateurMax) {
		super();
		this.utilisateurMax = utilisateurMax;
	}
	
	public Salle(int utilisateurMax, String adresse) {
		super();
		this.utilisateurMax = utilisateurMax;
		this.adresse = adresse;
	}
	
	public Salle(int utilisateurMax, String adresse, String contact) {
		super();
		this.utilisateurMax = utilisateurMax;
		this.adresse = adresse;
		this.contact = contact;
	}
}
