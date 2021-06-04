package fr.aston.vtc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.aston.vtc.dto.ClientDto;
import fr.aston.vtc.model.Client;
import fr.aston.vtc.service.ClientService;
import fr.aston.vtc.service.UserService;

@RestController
@RequestMapping("/client")
public class ClientResource {
	private final ClientService clientService;
	private final UserService userService;
	
	public ClientResource(ClientService clientService,UserService userService) {
		super();
		this.clientService = clientService;
		this.userService = userService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<?>> getAllClients(){
		List<Client> clients = clientService.findAllClients();
		List<ClientDto> clientDtos = new ArrayList<ClientDto>();
		for (Client client : clients) {
			clientDtos.add(new ClientDto(client));
		}
		return new ResponseEntity<>(clientDtos,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findClientById(@PathVariable("id") int id){
		 Client client = clientService.findClientById(id);
		return new ResponseEntity<>(new ClientDto(client),HttpStatus.OK);
	}
		
	@PostMapping("/add")
	public ResponseEntity<?> addClient(@RequestBody Client client){
		Client newClient = clientService.addClient(client);
		ClientDto clientDto = new ClientDto(newClient);

		return new ResponseEntity<>(clientDto,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateClient(@RequestBody Client client){
		Client updateClient = clientService.updateClient(client);
		return new ResponseEntity<>(new ClientDto(updateClient),HttpStatus.OK);
	}
	
	/*
	 * Delete en trois temps, dans l'ordre suivant: 
	 * 1) Delete les reservation(s)
	 * 2) Delete client
	 * 3) Delete user
	 * Pour éviter des erreurs liées aux clés étrangères
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteClient(@PathVariable("id") int id){
		Client client = clientService.findClientById(id);
		//Delete les reservation(s)
		
		clientService.deleteClient(id);
		
		userService.deleteUser(client.getUser().getId());
		return new ResponseEntity<>(HttpStatus.OK);
	}
}