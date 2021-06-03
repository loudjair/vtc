package fr.aston.vtc.dto;

import fr.aston.vtc.model.Client;

public class ClientDto {

	private int id;

	private String email;

	private String imageUrl;

	private String nom;

	private String prenom;

	private String telephone;
	
	private int userId;

	public ClientDto() {

	}

	public ClientDto(Client entite) {

		this.setEmail(entite.getUser().getEmail());
		this.setId(entite.getId());
		this.setImageUrl(entite.getUser().getImageUrl());
		this.setNom(entite.getUser().getNom());
		this.setPrenom(entite.getUser().getPrenom());
		this.setUserId(entite.getId());
		this.setTelephone(entite.getUser().getTelephone());
	}

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}