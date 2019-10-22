package fr.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ressourceMaterielle")
@Inheritance(strategy = InheritanceType.JOINED)
public class RessourceMaterielle {
	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RM_ID")
	private int id;

	@Column(name="RM_COUT")
	private float cout;
	
	@ManyToMany(mappedBy = "listRessourceMaterielle")
	private List<Planning> listPlanning;
	
	@ManyToMany	
	@JoinTable(
		name="resmaterielleformation",
		joinColumns=@JoinColumn(name="RM_FOR_ID", referencedColumnName="RM_ID"),
		inverseJoinColumns=@JoinColumn(name="FOR_RM_ID", referencedColumnName="FOR_ID")
	)
	private List<Formation> listFormation;
	
	@OneToMany(mappedBy = "ressourceMaterielle")
	private List<Disponibilite> listDisponibilite;
	
	@ManyToMany(mappedBy = "listRessourceMaterielle")
	private List<Technicien> listTechnicien;
	
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
