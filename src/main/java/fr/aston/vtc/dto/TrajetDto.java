package fr.aston.vtc.dto;

import java.math.BigDecimal;

import fr.aston.vtc.model.Trajet;

public class TrajetDto {

	private int id;
	private BigDecimal distance;
	private String itineraire;
	
	public TrajetDto() {
		
	}
	public TrajetDto(Trajet entite) {
		this.setDistance(entite.getDistance());
		this.setId(entite.getId());
		this.setItineraire(entite.getItineraire());
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getDistance() {
		return distance;
	}
	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}
	public String getItineraire() {
		return itineraire;
	}
	public void setItineraire(String itineraire) {
		this.itineraire = itineraire;
	}
}
