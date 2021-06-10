package fr.aston.vtc.dto;

import fr.aston.vtc.model.Client;

public class ClientDto extends UserDto{

	public ClientDto() {
		
	}

	public ClientDto(Client entite) {
		super(entite.getUser());	
	}

}