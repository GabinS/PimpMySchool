package fr.formation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "videoprojecteur")
@PrimaryKeyJoinColumn(name = "VID_ID", referencedColumnName = "RM_ID")
public class VideoProjecteur extends RessourceMaterielle{
	
	//Fields
	
	/**
	 * Resolution du Vid�oprojecteur (ex: 1080p)
	 */
	@Column(name = "VID_RESOLUTION")
	private int resolution;
	
	/**
	 * Dur�e de la vie de la lampe en nombre d'heure
	 */
	@Column(name = "VID_DUREEVIELAMPE")
	private int dureeVieLampe;
	
	/**
	 * Type de la lampe pr�sente (ex: LED, LASER)
	 */
	@Column(name = "VID_TYPELAMPE")
	private String typeLampe;
	
	/**
	 * Date d'achat du Vid�oprojecteur
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "VID_DATEACHAT")
	private Date dateAchat;
	
	//Properties
	
	/**
	 * R�cup�re la r�solution du Vid�oprojecteur
	 * @return La r�solution du Vid�oprojecteur
	 */
	public int getResolution() {
		return this.resolution;
	}
	
	/**
	 * D�fini la r�solution du Vid�oprojecteur
	 * @param resolution La nouvelle r�solution du Vid�oprojecteur
	 */
	public void setResolution(int resolution) {
		this.resolution = resolution;
	}
	
	/**
	 * R�cup�re la dur�e de vie de la lampe du Vid�oprojecteur
	 * @return La dur�e de vie du Vid�oprojecteur
	 */
	public int getDureeVieLampe() {
		return this.dureeVieLampe;
	}
	
	/**
	 * D�fini la dur�e de la vie de la lampe du Vid�oprojecteur
	 * @param dureeVie la nouvelle dur�e de vie du Vid�oprojecteur
	 */
	public void setDureeVieLampe(int dureeVie) {
		this.dureeVieLampe = dureeVie;
	}
	
	/**
	 * R�cup�re le type de lampe du Vid�oprojecteur
	 * @return Le type de la lampe du Vid�oprojecteur
	 */
	public String getTypeLampe() {
		return this.typeLampe;
	}
	
	/**
	 * D�fini le type de la lampe du Vid�oprojecteur
	 * @param typeLampe Le nouveau type de lampe du Vid�oprojecteur
	 */
	public void setTypeLampe(String typeLampe) {
		this.typeLampe = typeLampe;
	}
	
	/**
	 * R�cup�re la date d'achat du Vid�oprojecteur
	 * @return La date d'achat du Vid�oprojecteur
	 */
	public Date getDateAchat() {
		return dateAchat;
	}
	
	/**
	 * D�fini la date d'achat du Vid�oprojecteur
	 * @param dateAchat La nouvelle date d'achat du Vid�oprojecteur
	 */
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
	
	//Constructor
	public VideoProjecteur() {}
	
	public VideoProjecteur(
			int resolution, 
			int dureeVieLampe, 
			String typeLampe, 
			Date dateAchat) {
		
		super();
		this.resolution = resolution;
		this.dureeVieLampe = dureeVieLampe;
		this.typeLampe = typeLampe;
		this.dateAchat = dateAchat;
	}
	
}
