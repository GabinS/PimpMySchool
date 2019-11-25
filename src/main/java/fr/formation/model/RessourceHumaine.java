package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name = "ressourceHumaine")
@Inheritance(strategy = InheritanceType.JOINED)
public class RessourceHumaine{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RH_ID")
	private int id;
	
	@Column(name="RH_NOM")
	private String nom;
	
	@Column(name="RH_PRENOM")
	private String prenom;
	
	@Column(name="RH_ADRESSE")
	private String adresse;
	
	@Column(name="RH_TEL")
	private String tel;
	
	@Column(name="RH_MAIL")
	private String mail;
	
	@Column(name = "RH_USERNAME", nullable = false)
	private String username;
	
	@Column(name = "RH_PASSWORD", nullable = false)
	private String password;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "RH_TYPEUSER", nullable = false)
	private TypeUser typeUser;
	
	public RessourceHumaine() {
		
	}
	
	public RessourceHumaine(int id, String nom, String prenom, String adresse, String tel, String mail, String username,
			String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.mail = mail;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TypeUser getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(TypeUser typeUser) {
		this.typeUser = typeUser;
	}
	

}
