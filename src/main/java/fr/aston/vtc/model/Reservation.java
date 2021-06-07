package fr.aston.vtc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date rdv;

	//bi-directional many-to-one association to Facturation
	@OneToMany(mappedBy="reservation")
	private List<Facturation> facturations;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to Trajet
	@ManyToOne
	@JoinColumn(name="trajet_id")
	private Trajet trajet;

	public Reservation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getRdv() {
		return this.rdv;
	}

	public void setRdv(Date rdv) {
		this.rdv = rdv;
	}

	public List<Facturation> getFacturations() {
		return this.facturations;
	}

	public void setFacturations(List<Facturation> facturations) {
		this.facturations = facturations;
	}

	public Facturation addFacturation(Facturation facturation) {
		getFacturations().add(facturation);
		facturation.setReservation(this);

		return facturation;
	}

	public Facturation removeFacturation(Facturation facturation) {
		getFacturations().remove(facturation);
		facturation.setReservation(null);

		return facturation;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Trajet getTrajet() {
		return this.trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

}