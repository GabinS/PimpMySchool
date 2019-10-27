package fr.formation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ordinateur")
@PrimaryKeyJoinColumn(name = "ORD_ID", referencedColumnName = "RM_ID")
public class Ordinateur extends RessourceMaterielle{

	//Fields
	@Column(name = "ORD_NOM")
	private String nom;
	
	@Column(name = "ORD_PROC")
	private String processeur;

	@Column(name = "ORD_RAM")
	private String ram;
	
	@Column(name = "ORD_DISQUE")
	private String disqueDur;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ORD_DATEACHAT")
	private Date dateAchat;

	@OneToOne(mappedBy = "ordinateur")
	private Stagiaire stagiaire;

	//Properties

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public String getProcesseur() {
		return processeur;
	}

	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getDisqueDur() {
		return disqueDur;
	}

	public void setDisqueDur(String disqueDur) {
		this.disqueDur = disqueDur;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
	
	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}
	
	

	//Constructor
	public Ordinateur() {}
	
	public Ordinateur(String processeur, String ram, String disqueDur, Date dateAchat, String nom) {
		super();
		this.processeur = processeur;
		this.ram = ram;
		this.disqueDur = disqueDur;
		this.dateAchat = dateAchat;
		this.nom = nom;
	}
}
