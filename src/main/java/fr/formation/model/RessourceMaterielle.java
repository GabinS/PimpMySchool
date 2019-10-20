package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ressourcem")
public class RessourceMaterielle {

	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RM_ID")
	private int id;

	@Column(name="RM_COUT")
	private float cout;
	
	@OneToMany
	@JoinColumn(name="RM_DISPO")
	private boolean disponibilite;
	
	//Properties
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public float getCout() {return cout;}
	public void setCout(float cout) {this.cout = cout;}

	public boolean isDisponibilite() {return disponibilite;}
	public void setDisponibilite(boolean disponibilite) {this.disponibilite = disponibilite;}
	
	//Constructors
	public RessourceMaterielle() {}
	
	public RessourceMaterielle(int id) {
		this.id = id;
	}
	
	public RessourceMaterielle(int id, float cout) {
		this.id = id;
		this.cout = cout;
	}
	
	public RessourceMaterielle(int id, float cout, boolean disponibilite) {
		this.id = id;
		this.cout = cout;
		this.disponibilite = disponibilite;
	}
}
