package fr.aston.vtc.dto;


import fr.aston.vtc.model.Chauffeur;

public class ChauffeurDto extends UserDto{

	private int id;

	private float prixKilometrique;

	public ChauffeurDto() {

	}

	public ChauffeurDto(Chauffeur entite) {
		super(entite.getUser());
		this.setId(entite.getId());
		this.setPrixKilometrique(entite.getPrixKilometrique());
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public float getPrixKilometrique() {
		return prixKilometrique;
	}

	public void setPrixKilometrique(float prixKilometrique) {
		this.prixKilometrique = prixKilometrique;
	}

}