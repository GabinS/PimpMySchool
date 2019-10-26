package fr.formation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "technicien")
@PrimaryKeyJoinColumn(name = "TEC_ID", referencedColumnName = "RH_ID")
public class Technicien extends RessourceHumaine{
	
	@ManyToMany
	@JoinTable(
			name="technicienRessourceMaterielle",
			joinColumns=@JoinColumn(name="TEC_RM_ID", referencedColumnName="TEC_ID"),
			inverseJoinColumns=@JoinColumn(name="RM_TEC_ID", referencedColumnName="RM_ID")
		)
	private List<RessourceMaterielle> listRessourceMaterielle;

	public Technicien() {
		
	}	
	
	public Technicien(List<RessourceMaterielle> listRessourceMaterielle) {
		super();
		this.listRessourceMaterielle = listRessourceMaterielle;
	}

	public List<RessourceMaterielle> getListRessourceMaterielle() {
		return listRessourceMaterielle;
	}

	public void setListRessourceMaterielle(List<RessourceMaterielle> listRessourceMaterielle) {
		this.listRessourceMaterielle = listRessourceMaterielle;
	}
	
	
}
