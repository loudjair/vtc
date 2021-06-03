package fr.aston.vtc.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aston.vtc.model.Chauffeur;

public interface ChauffeurRepo extends JpaRepository<Chauffeur, Long>{
	void deleteChauffeurById(int id);
	Optional<Chauffeur> findChauffeurById(int id);
}
