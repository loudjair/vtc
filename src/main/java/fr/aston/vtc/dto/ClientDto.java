package fr.aston.vtc.dto;

import fr.aston.vtc.model.Client;

public class ClientDto extends UserDto{

	private int id;

	public ClientDto() {
		
	}

	public ClientDto(Client entite) {
		super(entite.getUser());
		this.setId(entite.getId());
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}