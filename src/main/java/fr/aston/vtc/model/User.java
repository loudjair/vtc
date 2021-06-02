package fr.aston.vtc.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false,updatable = false)
	private Long id;
	
	@Column(nullable=false)
	private String nom;
	
	@Column(nullable=false)
	private String prenom;
	
	@Column(nullable=false,unique = true)
	private String email;
	
	@Column(nullable=false,unique = true)
	private String telephone;
	
	/*
	 *	URL de l'image user 
	 */
	
	// @Column(nullable=true, updatable = true)
	// private String urlImage;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String nom, String prenom, String email, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone="
				+ telephone + "]";
	}

}
