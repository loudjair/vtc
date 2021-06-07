package fr.aston.vtc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the facturation database table.
 * 
 */
@Entity
@NamedQuery(name="Facturation.findAll", query="SELECT f FROM Facturation f")
public class Facturation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private float prix;

	//bi-directional many-to-one association to Chauffeur
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="chauffeur_id")
	private Chauffeur chauffeur;

	//bi-directional many-to-one association to Reservation
	@ManyToOne
	private Reservation reservation;

	public Facturation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Chauffeur getChauffeur() {
		return this.chauffeur;
	}

	public void setChauffeur(Chauffeur chauffeur) {
		this.chauffeur = chauffeur;
	}

	public Reservation getReservation() {
		return this.reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}