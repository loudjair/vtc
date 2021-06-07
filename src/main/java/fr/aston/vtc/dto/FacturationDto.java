package fr.aston.vtc.dto;


import fr.aston.vtc.model.Chauffeur;
import fr.aston.vtc.model.Facturation;
import fr.aston.vtc.model.Reservation;

public class FacturationDto {
	
	private int id;
	
	private float prix;
	
	private Chauffeur chauffeur;
	
	private Reservation reservation;
	
	public FacturationDto() {
		
	}
	
	public FacturationDto(Facturation entite) {
		this.setId(entite.getId());
		this.setPrix(entite.getPrix());
		this.setChauffeur(entite.getChauffeur());
		this.setReservation(entite.getReservation());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Chauffeur getChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(Chauffeur chauffeur) {
		this.chauffeur = chauffeur;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}
