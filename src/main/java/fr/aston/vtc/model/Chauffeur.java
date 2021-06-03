package fr.aston.vtc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the chauffeur database table.
 * 
 */
@Entity
@NamedQuery(name="Chauffeur.findAll", query="SELECT c FROM Chauffeur c")
public class Chauffeur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="prix_kilometrique")
	private BigDecimal prixKilometrique;

	//bi-directional many-to-one association to User
	@ManyToOne(cascade=CascadeType.ALL)
	private User user;

	//bi-directional many-to-one association to Facturation
	@OneToMany(mappedBy="chauffeur")
	private List<Facturation> facturations;

	//bi-directional many-to-one association to Vehicule
	@OneToMany(mappedBy="chauffeur")
	private List<Vehicule> vehicules;

	public Chauffeur() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPrixKilometrique() {
		return this.prixKilometrique;
	}

	public void setPrixKilometrique(BigDecimal prixKilometrique) {
		this.prixKilometrique = prixKilometrique;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Facturation> getFacturations() {
		return this.facturations;
	}

	public void setFacturations(List<Facturation> facturations) {
		this.facturations = facturations;
	}

	public Facturation addFacturation(Facturation facturation) {
		getFacturations().add(facturation);
		facturation.setChauffeur(this);

		return facturation;
	}

	public Facturation removeFacturation(Facturation facturation) {
		getFacturations().remove(facturation);
		facturation.setChauffeur(null);

		return facturation;
	}

	public List<Vehicule> getVehicules() {
		return this.vehicules;
	}

	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	public Vehicule addVehicule(Vehicule vehicule) {
		getVehicules().add(vehicule);
		vehicule.setChauffeur(this);

		return vehicule;
	}

	public Vehicule removeVehicule(Vehicule vehicule) {
		getVehicules().remove(vehicule);
		vehicule.setChauffeur(null);

		return vehicule;
	}

}