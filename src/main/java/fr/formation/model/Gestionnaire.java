package fr.formation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "gestionnaire")
@PrimaryKeyJoinColumn(name = "GEST_ID", referencedColumnName = "RH_ID")
public class Gestionnaire extends RessourceHumaine{
	
	@OneToMany(mappedBy = "gestionnaire")
	private List<Formation> listFormation;

	public Gestionnaire() {
		
	}
	
	public List<Formation> getListFormation() {
		return listFormation;
	}

	public void setListFormation(List<Formation> listFormation) {
		this.listFormation = listFormation;
	}
	
}
