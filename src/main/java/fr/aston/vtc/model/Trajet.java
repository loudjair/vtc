package fr.aston.vtc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the trajet database table.
 * 
 */
@Entity
@NamedQuery(name="Trajet.findAll", query="SELECT t FROM Trajet t")
public class Trajet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private float distance;

	@Column(nullable=false)
	private String itineraire;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="trajet")
	private List<Reservation> reservations;

	public Trajet() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getDistance() {
		return this.distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public String getItineraire() {
		return this.itineraire;
	}

	public void setItineraire(String itineraire) {
		this.itineraire = itineraire;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setTrajet(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setTrajet(null);

		return reservation;
	}

}