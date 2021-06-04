package fr.aston.vtc.dto;

import java.util.Date;
import java.util.List;

import fr.aston.vtc.model.Client;
import fr.aston.vtc.model.Facturation;
import fr.aston.vtc.model.Reservation;
import fr.aston.vtc.model.Trajet;

public class ReservationDto {
	
	private int id;

	private Date rdv;

	private List<Facturation> facturations;

	private Client client;
	
	private Trajet trajet;
	
	public ReservationDto() {
		super();
	}
	
	public ReservationDto(Reservation entite) {
		this.setId(entite.getClient().getId());
		this.setClient(entite.getClient());
		this.setRdv(entite.getRdv());
		this.setFacturations(entite.getFacturations());
		this.setTrajet(entite.getTrajet());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getRdv() {
		return rdv;
	}

	public void setRdv(Date rdv) {
		this.rdv = rdv;
	}

	public List<Facturation> getFacturations() {
		return facturations;
	}

	public void setFacturations(List<Facturation> facturations) {
		this.facturations = facturations;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	

}
