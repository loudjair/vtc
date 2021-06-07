package fr.aston.vtc.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aston.vtc.model.Trajet;

public interface TrajetRepo extends JpaRepository<Trajet,Long> {

	@Transactional
	void deleteTrajetById(int id);
	
	Optional<Trajet> findTrajetById(int id);
}
