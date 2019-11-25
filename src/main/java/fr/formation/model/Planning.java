package fr.formation.model;

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
	
	/**
	 *  Numéro d'identification du planning.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLA_ID")
	private int id;
	
	/** 
	 * Date de début du cours.
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PLA_DAT_DEB")
	private Date dateDebut;
	
	/**
	 *  Date de fin du cours.
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PLA_DAT_FIN")
	private Date dateFin;
	
	/**
	 *  Liste des ressources matérielles (salle, ordinateur et/ou vidéoprojecteur) demandées pour le cours.
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="planningRessourceMat",
		joinColumns=@JoinColumn(name="PLA_RM_ID", referencedColumnName="PLA_ID"),
		inverseJoinColumns=@JoinColumn(name="RM_PLA_ID", referencedColumnName="RM_ID")
	)
	private List<RessourceMaterielle> listRessourceMaterielle;
	
	/**
	 *  Informations sur la matière enseignée. 
	 */
	@ManyToOne
	@JoinColumn(name="PLA_MAT_ID")
	private Matiere matiere;

	/**
	 *  Informations sur la formation.
	 */
	@ManyToOne
	@JoinColumn(name="PLA_FOR_ID")
	private Formation formation;
	
	/**
	 * Récupère le numéro d'identification du planning.
	 * @return le numéro d'identification du planning.
	 */
	public int getId() { 
		return id; 
		}

	/**
	 * Récupère la date de début du cours.
	 * @return la date de début du cours.
	 */
	public Date getDateDebut() { 
		return dateDebut; 
		}
	
	/**
	 * Récupère la date de fin du cours.
	 * @return la date de fin du cours.
	 */
	public Date getDateFin() { 
		return dateFin; 
		}

	/**
	 * Récupère la liste du matériel demandé pour le cours.
	 * @return la liste du matériel demandé pour le cours.
	 */
	public List<RessourceMaterielle> getListRessourceMat() {
		return listRessourceMaterielle;
	}
	
	/**
	 * Récupère les informations sur la matière enseignée.
	 * @return les informations sur la matière enseignée.
	 */
	public Matiere getMatiere() {
		return matiere;
	}

	/**
	 * Récupère les informations sur la formation.
	 * @return les informations sur la formation.
	 */
	public Formation getFormation() {
		return formation;
	}
	
	/**
	 * Défini le numéro d'identification du planning. 
	 * @param id le numéro d'identification du planning
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Défini la date de début du cours.
	 * @return la date de début du cours.
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Défini la date de fin du cours.
	 * @return la date de fin du cours.
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	/**
	 * Défini la liste du matériel.
	 * @param listRessourceMat la liste du matériel.
	 */
	public void setListRessourceMat(List<RessourceMaterielle> listRessourceMat) {
		this.listRessourceMaterielle = listRessourceMat;
	}

	/**
	 * Défini la matière.
	 * @return la matière.
	 */
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	/**
	 * Défini la formation.
	 * @param formation la formation.
	 */
	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	/**
	 * Constructeur du planning.
	 * @param id Le nuémro d'identification du planning.
	 * @param dateDebut La date de début du cours.
	 * @param dateFin La date de fin du planning.
	 * @param listRessourceMat La liste des ressources humaines.
	 * @param matiere La matière.
	 * @param formation La formation.
	 */
	public Planning(int id, Date dateDebut, Date dateFin, List<RessourceMaterielle> listRessourceMat, Matiere matiere,
			Formation formation) {
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.listRessourceMaterielle = listRessourceMat;
		this.matiere = matiere;
		this.formation = formation;
	}
	
	/**
	 * Constructeur du planning.
	 * @param id Le nuémro d'identification du planning.
	 * @param dateDebut La date de début du cours.
	 * @param dateFin La date de fin du planning.
	 * @param matiere La matière.
	 * @param formation La formation.
	 */
	public Planning(int id, Date dateDebut, Date dateFin, Matiere matiere,
			Formation formation) {
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.matiere = matiere;
		this.formation = formation;
	}
	
	/**
	 * Constructeur du planning.
	 * @param id Le nuémro d'identification du planning.
	 * @param matiere La matière.
	 * @param formation La formation.
	 */
	public Planning(int id, Matiere matiere, Formation formation) {
		this.id = id;
		this.matiere = matiere;
		this.formation = formation;
	}
	
	/**
	 * Constructeur du planning.
	 * @param id Le nuémro d'identification du planning.
	 */
	public Planning(int id) {
		this.id = id;
	}
	
	/**
	 * Constructeur vide pour permettre la création d'un planning.
	 */
	public Planning() {
		super();
	}
}
