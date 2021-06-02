package fr.aston.vtc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vehicule database table.
 * 
 */
@Entity
@NamedQuery(name="Vehicule.findAll", query="SELECT v FROM Vehicule v")
public class Vehicule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String marque;

	private String modele;

	//bi-directional many-to-one association to Chauffeur
	@ManyToOne
	private Chauffeur chauffeur;

	public Vehicule() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return this.modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public Chauffeur getChauffeur() {
		return this.chauffeur;
	}

	public void setChauffeur(Chauffeur chauffeur) {
		this.chauffeur = chauffeur;
	}

}