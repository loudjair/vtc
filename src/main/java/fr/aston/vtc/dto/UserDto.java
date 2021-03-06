package fr.aston.vtc.dto;

import fr.aston.vtc.model.User;

public class UserDto {
	private int id;

	private String email;
	
	private String password;

	private String imageUrl;

	private String nom;

	private String prenom;

	private String telephone;
	
	
	public UserDto() {
		
	}
	
	public UserDto(User entite) {
		this.setId(entite.getId());
		this.setEmail(entite.getEmail());
		this.setPassword(entite.getPassword());
		this.setImageUrl(entite.getImageUrl());
		this.setNom(entite.getNom());
		this.setPrenom(entite.getPrenom());
		this.setTelephone(entite.getTelephone());
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
