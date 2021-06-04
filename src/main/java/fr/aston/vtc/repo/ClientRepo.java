package fr.aston.vtc.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aston.vtc.model.Client;

public interface ClientRepo extends JpaRepository<Client, Long>{
	void deleteClientById(int id);
	Optional<Client> findClientById(int id);
}
