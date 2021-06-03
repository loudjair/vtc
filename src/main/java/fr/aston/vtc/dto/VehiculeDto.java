package fr.aston.vtc.dto;

import fr.aston.vtc.model.Vehicule;

public class VehiculeDto {
	private int id;

	private String marque;

	private String modele;
	
	private int chauffeurId;
	
	public VehiculeDto() {
		
	}

	public VehiculeDto(Vehicule entite) {
		this.setId(entite.getId());
		this.setMarque(entite.getMarque());
		this.setModele(entite.getModele());
		this.setChauffeurId(entite.getChauffeur().getId());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getChauffeurId() {
		return chauffeurId;
	}

	public void setChauffeurId(int chauffeurId) {
		this.chauffeurId = chauffeurId;
	}
}
