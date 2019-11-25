package fr.formation.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	private Date dateDebut;
	
	@Column(name="DIS_DATEFIN")
	private Date dateFin;
	
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
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
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

	//Constructors
	public Disponibilite() {}
	
	public Disponibilite(Date dateDebut, Date dateFin) {
		super();
		
		// Test pour déterminer le format de date nécessaire
		/*SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("+++++++++++++++");
		System.out.println(dateDebut);
		System.out.println(dateFin);
		System.out.println("+++++++++++++++");
		this.dateDebut = StringToDate(dateFormat.format(dateDebut));
		this.dateFin = StringToDate(dateFormat.format(dateFin));
		System.out.println("+++++++++++++++");
		System.out.println(this.dateDebut);
		System.out.println(this.dateFin);
		System.out.println("+++++++++++++++");*/
	}
	
	public Disponibilite(String dateDebut, String dateFin) {
		super();
		this.dateDebut = StringToDate(dateDebut);
		this.dateFin = StringToDate(dateFin);
	}
	
	//Methods
	public Date StringToDate(String s){
	    Date result = null;
	    try{
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	        result  = dateFormat.parse(s);
	    }
	    catch(ParseException e){
	        e.printStackTrace();
	    }
	    return result ;
	}
	
}
