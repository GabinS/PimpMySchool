package fr.formation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IDAOVideoProjecteur;
import fr.formation.model.VideoProjecteur;

@Service
public class VideoProjecteurService {
	
	@Autowired(required=false)
	private IDAOVideoProjecteur daoVideoProjecteur;
	
	/**
	 * Récupère tout les VidéoProjecteurs 
	 * @return
	 */
	public List<VideoProjecteur> findAll() {
		return daoVideoProjecteur.findAll();
	}
	
	/**
	 * Récupère un VidéoProjecteur par son identifiant
	 * @param id Identifiant du VidéoProjecteur
	 * @return
	 */
	public VideoProjecteur getById(int id) {
		return daoVideoProjecteur.findById(id);
	}
	
	/**
	 * Ajoute un VideoProjecteur
	 * @param videoProjecteur
	 * @return
	 */
	@Transactional
	public VideoProjecteur add(VideoProjecteur videoProjecteur) {
		return daoVideoProjecteur.save(videoProjecteur);
	}
	
	/**
	 * Suppression du VideoProjecteur par identifiant
	 * @param id Identifiant du VidéoProjecteur
	 */
	@Transactional
	public void deleteById(int id) {
		daoVideoProjecteur.deleteById(id);
	}

	/**
	 * Mise à jour du VideoProjecteur
	 * @param videoProjecteur Le nouvelle objet videoProjecteur
	 */
	@Transactional
	public void update(VideoProjecteur videoProjecteur) {
		daoVideoProjecteur.save(videoProjecteur);
	}
}
