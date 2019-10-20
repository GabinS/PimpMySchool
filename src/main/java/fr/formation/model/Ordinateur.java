package fr.formation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ordinateur")
public class Ordinateur extends RessourceMaterielle{

	//Fields
	@Column(name = "ORD_PROC")
	private String processeur;
	
	@Column(name = "ORD_RAM")
	private String ram;
	
	@Column(name = "ORD_DISQUE")
	private String disqueDur;
	
	@Column(name = "ORD_DATEACHAT")
	private Date dateAchat;

	
	//Properties
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

	//Constructor
	public Ordinateur() {}
	
	public Ordinateur(String processeur, String ram, String disqueDur, Date dateAchat) {
		super();
		this.processeur = processeur;
		this.ram = ram;
		this.disqueDur = disqueDur;
		this.dateAchat = dateAchat;
	}
}
