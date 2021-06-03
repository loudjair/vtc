package fr.aston.vtc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aston.vtc.exception.ClientNotFoundException;
import fr.aston.vtc.model.Client;
import fr.aston.vtc.repo.ClientRepo;

@Service
public class ClientService {

	private final ClientRepo clientRepo;
	
	@Autowired
	public ClientService(ClientRepo clientRepo) {
		super();
		this.clientRepo = clientRepo;
	}
	
	public Client addClient(Client client) {
		return clientRepo.save(client);
	}
	
	public List<Client> findAllClients(){
		return clientRepo.findAll();
	}
	
	public Client updateClient(Client client) {
		return clientRepo.save(client);
	}
	
	public Client findClientById(int id){
		return clientRepo.findClientById(id)
				.orElseThrow(()-> new ClientNotFoundException("Client by id "+id+" was not found"));
	}
	
	public void deleteClient(int id) {
		clientRepo.deleteClientById(id);
	}
	

}
