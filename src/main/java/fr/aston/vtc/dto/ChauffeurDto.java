package fr.aston.vtc.dto;

import java.math.BigDecimal;

import fr.aston.vtc.model.Chauffeur;

<<<<<<< HEAD
public class ChauffeurDto {

	private int id;
	private String email;
	private String imageUrl;
	private String nom;
	private String prenom;
	private String telephone;
	private BigDecimal prixKilometrique;
	private int userId;

	public ChauffeurDto() {
	}

	public ChauffeurDto(Chauffeur entite) {

=======
public class ChauffeurDto{

	private int id;

	private String email;

	private String imageUrl;

	private String nom;

	private String prenom;

	private String telephone;
	
	private BigDecimal prixKilometrique;
	
	private int userId;

	public ChauffeurDto() {
		
	}
	
	public ChauffeurDto(Chauffeur entite) {
		
		
>>>>>>> 86d507fcf7cfd8fff4dfd4f49425cbb6d8209fe7
		this.setEmail(entite.getUser().getEmail());
		this.setId(entite.getId());
		this.setImageUrl(entite.getUser().getImageUrl());
		this.setNom(entite.getUser().getNom());
		this.setPrenom(entite.getUser().getPrenom());
		this.setPrixKilometrique(entite.getPrixKilometrique());
		this.setUserId(entite.getId());
		this.setTelephone(entite.getUser().getTelephone());
	}
<<<<<<< HEAD

=======
	
	
>>>>>>> 86d507fcf7cfd8fff4dfd4f49425cbb6d8209fe7
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public BigDecimal getPrixKilometrique() {
		return prixKilometrique;
	}

	public void setPrixKilometrique(BigDecimal prixKilometrique) {
		this.prixKilometrique = prixKilometrique;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 86d507fcf7cfd8fff4dfd4f49425cbb6d8209fe7
