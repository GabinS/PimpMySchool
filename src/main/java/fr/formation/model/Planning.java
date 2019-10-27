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
	 *  Num�ro d'identification du planning.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLA_ID")
	private int id;
	
	/** 
	 * Date de d�but du cours.
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
	 *  Liste des ressources mat�rielles (salle, ordinateur et/ou vid�oprojecteur) demand�es pour le cours.
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="planningRessourceMat",
		joinColumns=@JoinColumn(name="PLA_RM_ID", referencedColumnName="PLA_ID"),
		inverseJoinColumns=@JoinColumn(name="RM_PLA_ID", referencedColumnName="RM_ID")
	)
	private List<RessourceMaterielle> listRessourceMaterielle;
	
	/**
	 *  Informations sur la mati�re enseign�e. 
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
	 * R�cup�re le num�ro d'identification du planning.
	 * @return le num�ro d'identification du planning.
	 */
	public int getId() { 
		return id; 
		}

	/**
	 * R�cup�re la date de d�but du cours.
	 * @return la date de d�but du cours.
	 */
	public Date getDateDebut() { 
		return dateDebut; 
		}
	
	/**
	 * R�cup�re la date de fin du cours.
	 * @return la date de fin du cours.
	 */
	public Date getDateFin() { 
		return dateFin; 
		}

	/**
	 * R�cup�re la liste du mat�riel demand� pour le cours.
	 * @return la liste du mat�riel demand� pour le cours.
	 */
	public List<RessourceMaterielle> getListRessourceMat() {
		return listRessourceMaterielle;
	}
	
	/**
	 * R�cup�re les informations sur la mati�re enseign�e.
	 * @return les informations sur la mati�re enseign�e.
	 */
	public Matiere getMatiere() {
		return matiere;
	}

	/**
	 * R�cup�re les informations sur la formation.
	 * @return les informations sur la formation.
	 */
	public Formation getFormation() {
		return formation;
	}
	
	/**
	 * D�fini le num�ro d'identification du planning. 
	 * @param id le num�ro d'identification du planning
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * D�fini la date de d�but du cours.
	 * @return la date de d�but du cours.
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * D�fini la date de fin du cours.
	 * @return la date de fin du cours.
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	/**
	 * D�fini la liste du mat�riel.
	 * @param listRessourceMat la liste du mat�riel.
	 */
	public void setListRessourceMat(List<RessourceMaterielle> listRessourceMat) {
		this.listRessourceMaterielle = listRessourceMat;
	}

	/**
	 * D�fini la mati�re.
	 * @return la mati�re.
	 */
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	/**
	 * D�fini la formation.
	 * @param formation la formation.
	 */
	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	/**
	 * Constructeur du planning.
	 * @param id Le nu�mro d'identification du planning.
	 * @param dateDebut La date de d�but du cours.
	 * @param dateFin La date de fin du planning.
	 * @param listRessourceMat La liste des ressources humaines.
	 * @param matiere La mati�re.
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
	 * @param id Le nu�mro d'identification du planning.
	 * @param dateDebut La date de d�but du cours.
	 * @param dateFin La date de fin du planning.
	 * @param matiere La mati�re.
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
	 * @param id Le nu�mro d'identification du planning.
	 * @param matiere La mati�re.
	 * @param formation La formation.
	 */
	public Planning(int id, Matiere matiere, Formation formation) {
		this.id = id;
		this.matiere = matiere;
		this.formation = formation;
	}
	
	/**
	 * Constructeur du planning.
	 * @param id Le nu�mro d'identification du planning.
	 */
	public Planning(int id) {
		this.id = id;
	}
	
	/**
	 * Constructeur vide pour permettre la cr�ation d'un planning.
	 */
	public Planning() {
		super();
	}
}
