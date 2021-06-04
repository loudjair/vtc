package fr.aston.vtc.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aston.vtc.model.Client;

public interface ClientRepo extends JpaRepository<Client, Long>{
	/*
	 * Annotation importante pour supprimer l'entite
	 */
	@Transactional
	void deleteClientById(int id);
	Optional<Client> findClientById(int id);
}
