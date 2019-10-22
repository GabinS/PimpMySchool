package fr.formation.model;

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
	@Column(name="PLA_DATE_DEB")
	private Date dateDebut;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PLA_DATE_FIN")
	private Date dateFin;
	
	@ManyToMany
	@JoinTable(
			name="planningRessourceMat",
			joinColumns=@JoinColumn(name="PLA_RES_MAT_ID", referencedColumnName="PLA_ID"),
			inverseJoinColumns=@JoinColumn(name="RES_MAT_PLA_ID", referencedColumnName="RM_ID")
		)
	private List<RessourceMaterielle> listRessourceMat;
	
	// TODO
	@ManyToOne
	@JoinColumn(name="PLA_MATIERE_ID")
	private Matiere matiere;

	// TODO
	@ManyToOne
	@JoinColumn(name="PLA_FORMATION_ID")
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
		return listRessourceMat;
	}

	public void setListRessourceMat(List<RessourceMaterielle> listRessourceMat) {
		this.listRessourceMat = listRessourceMat;
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
		this.listRessourceMat = listRessourceMat;
		this.matiere = matiere;
		this.formation = formation;
	}
	
	public Planning() {
		super();
	}
}
