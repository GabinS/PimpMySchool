package fr.formation.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "planning")
public class Planning {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLA_ID")
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PLA_DAT_DEB")
	private Date dateDebut;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PLA_DAT_FIN")
	private Date dateFin;
	
	@ManyToMany
	@JoinTable(
		name="planningRessourceMat",
		joinColumns=@JoinColumn(name="PLA_RM_ID", referencedColumnName="PLA_ID"),
		inverseJoinColumns=@JoinColumn(name="RM_PLA_ID", referencedColumnName="RM_ID")
	)
	private List<RessourceMaterielle> listRessourceMaterielle;
	
	@ManyToOne
	@JoinColumn(name="PLA_MAT_ID")
	private Matiere matiere;

	@ManyToOne
	@JoinColumn(name="PLA_FOR_ID")
	private Formation formation;
	
	public int getId() {
		return id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}
	
	public String getDateDebutDayOfWeek() {
		DateFormat f = new SimpleDateFormat("EEEEE");
		return f.format(dateDebut);
	}
	
	public String getDateDebutDayOfMonth() {
		DateFormat f = new SimpleDateFormat("dd");
		return f.format(dateDebut);
	}
	
	public String getDateDebutMonth() {
		DateFormat f = new SimpleDateFormat("MMMMM");
		return f.format(dateDebut);
	}
	
	public String getDateDebutYear() {
		DateFormat f = new SimpleDateFormat("YYYY");
		return f.format(dateDebut);
	}

	public Date getDateFin() {
		return dateFin;
	}
	
	public String getDateFinDayOfWeek() {
		DateFormat f = new SimpleDateFormat("EEEEE");
		return f.format(dateFin);
	}
	
	public String getDateFinDayOfMonth() {
		DateFormat f = new SimpleDateFormat("dd");
		return f.format(dateFin);
	}
	
	public String getDateFinMonth() {
		DateFormat f = new SimpleDateFormat("MMMMM");
		return f.format(dateFin);
	}
	
	public String getDateFinYear() {
		DateFormat f = new SimpleDateFormat("YYYY");
		return f.format(dateFin);
	}

	public List<RessourceMaterielle> getListRessourceMat() {
		return listRessourceMaterielle;
	}

	public void setListRessourceMat(List<RessourceMaterielle> listRessourceMat) {
		this.listRessourceMaterielle = listRessourceMat;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Planning(int id, Date dateDebut, Date dateFin, List<RessourceMaterielle> listRessourceMat, Matiere matiere,
			Formation formation) {
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.listRessourceMaterielle = listRessourceMat;
		this.matiere = matiere;
		this.formation = formation;
	}
	
	public Planning(int id, Date dateDebut, Date dateFin, Matiere matiere,
			Formation formation) {
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.matiere = matiere;
		this.formation = formation;
	}
	
	public Planning(int id) {
		this.id = id;
	}
	
	public Planning() {
		super();
	}
}
