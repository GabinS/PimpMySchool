package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ressourceMaterielle")
public class RessourceMaterielle {
	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RM_ID")
	private int id;

	@Column(name="RM_COUT")
	private float cout;
	
	@ManyToMany
	@JoinColumn(name="RM_PLANNING")
	private Planning planning;
	
	@ManyToMany
	@JoinColumn(name="RM_FORMATION")
	private Formation formation;
	
	@OneToMany
	@JoinColumn(name="RM_DISPO")
	private Disponibilite disponibilite;
	
	@ManyToMany
	@JoinColumn(name="RM_TECHNICIEN")
	private Technicien technicien;
	
	//Properties
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public float getCout() {return cout;}
	public void setCout(float cout) {this.cout = cout;}
	
	//Constructors
	public RessourceMaterielle() {}
	
	public RessourceMaterielle(int id) {
		this.id = id;
	}
	
	public RessourceMaterielle(int id, float cout) {
		this.id = id;
		this.cout = cout;
	}
}
