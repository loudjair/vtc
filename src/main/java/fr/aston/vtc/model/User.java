package fr.aston.vtc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false,unique=true)
	private String email;
	
	@Column(nullable=false,columnDefinition="TEXT")
	private String password;

	@Column(name="image_url")
	private String imageUrl;

	@Column(nullable=false)
	private String nom;

	@Column(nullable=false)
	private String prenom;
	
	@Column(nullable=false,unique=true)
	private String telephone;

	public User(String email, String imageUrl, String nom, String prenom, String telephone,
			List<Chauffeur> chauffeurs, List<Client> clients) {
		this.email = email;
		this.imageUrl = imageUrl;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.chauffeurs = chauffeurs;
		this.clients = clients;
	}

	//bi-directional many-to-one association to Chauffeur
	@OneToMany(mappedBy="user")
	private List<Chauffeur> chauffeurs;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="user")
	private List<Client> clients;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Chauffeur> getChauffeurs() {
		return this.chauffeurs;
	}

	public void setChauffeurs(List<Chauffeur> chauffeurs) {
		this.chauffeurs = chauffeurs;
	}

	public Chauffeur addChauffeur(Chauffeur chauffeur) {
		getChauffeurs().add(chauffeur);
		chauffeur.setUser(this);

		return chauffeur;
	}

	public Chauffeur removeChauffeur(Chauffeur chauffeur) {
		getChauffeurs().remove(chauffeur);
		chauffeur.setUser(null);

		return chauffeur;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setUser(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setUser(null);

		return client;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", imageUrl=" + imageUrl + ", nom=" + nom + ", prenom=" + prenom
				+ ", telephone=" + telephone + ", chauffeurs=" + chauffeurs + ", clients=" + clients + "]";
	}

}