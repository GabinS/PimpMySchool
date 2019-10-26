package fr.formation.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IDAOFormateur;
import fr.formation.model.Formateur;

@Repository
public class DAOFormateurJpa extends DAOJpa<Formateur> implements IDAOFormateur {
	public DAOFormateurJpa() {
		this._Class = Formateur.class;
	}

	public Formateur findFormateur(String username) {
		try {
			return em.createQuery("select f from Formateur f where f.username = :username", Formateur.class)
					.setParameter("username", username).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}