package fr.formation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="disponibilite")
public class Disponibilite {

	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DIS_ID")
	private int id;
	
	@Column(name="DIS_DATEDEB")
	private Date DateDebut;
	
	@Column(name="DIS_DATEFIN")
	private Date DateFin;
	
	@ManyToOne
	@JoinColumn(name="DIS_RM_ID")
	private RessourceMaterielle ressourceMaterielle;
	
	@ManyToOne
	@JoinColumn(name="DIS_FEUR_ID")
	private Formateur formateur;

	//Properties
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return DateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		DateDebut = dateDebut;
	}

	public Date getDateFin() {
		return DateFin;
	}

	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}

	public RessourceMaterielle getRessourceMaterielle() {
		return ressourceMaterielle;
	}

	public void setRessourceMaterielle(RessourceMaterielle ressourceMaterielle) {
		this.ressourceMaterielle = ressourceMaterielle;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	//Constructor
	public Disponibilite() {}
	
	public Disponibilite(int id, Date dateDebut, Date dateFin) {
		super();
		this.id = id;
		DateDebut = dateDebut;
		DateFin = dateFin;
	}
	
	
}
