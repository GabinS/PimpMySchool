package fr.formation.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "planning")
public class Planning {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLA_ID")
	private int id;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PLA_DAT_DEB")
	private Date dateDebut;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PLA_DAT_FIN")
	private Date dateFin;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="planningRessourceMat",
		joinColumns=@JoinColumn(name="PLA_RM_ID", referencedColumnName="PLA_ID"),
		inverseJoinColumns=@JoinColumn(name="RM_PLA_ID", referencedColumnName="RM_ID")
	)
	private List<RessourceMaterielle> listRessourceMaterielle;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PLA_MAT_ID")
	private Matiere matiere;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PLA_FOR_ID")
	private Formation formation;
	
	public int getId() {
		return id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}
	
	public Date getDateFin() {
		return dateFin;
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
	
	public Planning(int id, Matiere matiere, Formation formation) {
		this.id = id;
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
