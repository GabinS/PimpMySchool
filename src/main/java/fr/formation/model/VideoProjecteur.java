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
	 * Resolution du Vidéoprojecteur (ex: 1080p)
	 */
	@Column(name = "VID_RESOLUTION")
	private int resolution;
	
	/**
	 * Durée de la vie de la lampe en nombre d'heure
	 */
	@Column(name = "VID_DUREEVIELAMPE")
	private int dureeVieLampe;
	
	/**
	 * Type de la lampe présente (ex: LED, LASER)
	 */
	@Column(name = "VID_TYPELAMPE")
	private String typeLampe;
	
	/**
	 * Date d'achat du Vidéoprojecteur
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "VID_DATEACHAT")
	private Date dateAchat;
	
	//Properties
	
	/**
	 * Récupère la résolution du Vidéoprojecteur
	 * @return La résolution du Vidéoprojecteur
	 */
	public int getResolution() {
		return this.resolution;
	}
	
	/**
	 * Défini la résolution du Vidéoprojecteur
	 * @param resolution La nouvelle résolution du Vidéoprojecteur
	 */
	public void setResolution(int resolution) {
		this.resolution = resolution;
	}
	
	/**
	 * Récupère la durée de vie de la lampe du Vidéoprojecteur
	 * @return La durée de vie du Vidéoprojecteur
	 */
	public int getDureeVieLampe() {
		return this.dureeVieLampe;
	}
	
	/**
	 * Défini la durée de la vie de la lampe du Vidéoprojecteur
	 * @param dureeVie la nouvelle durée de vie du Vidéoprojecteur
	 */
	public void setDureeVieLampe(int dureeVie) {
		this.dureeVieLampe = dureeVie;
	}
	
	/**
	 * Récupère le type de lampe du Vidéoprojecteur
	 * @return Le type de la lampe du Vidéoprojecteur
	 */
	public String getTypeLampe() {
		return this.typeLampe;
	}
	
	/**
	 * Défini le type de la lampe du Vidéoprojecteur
	 * @param typeLampe Le nouveau type de lampe du Vidéoprojecteur
	 */
	public void setTypeLampe(String typeLampe) {
		this.typeLampe = typeLampe;
	}
	
	/**
	 * Récupère la date d'achat du Vidéoprojecteur
	 * @return La date d'achat du Vidéoprojecteur
	 */
	public Date getDateAchat() {
		return dateAchat;
	}
	
	/**
	 * Défini la date d'achat du Vidéoprojecteur
	 * @param dateAchat La nouvelle date d'achat du Vidéoprojecteur
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
