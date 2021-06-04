package fr.aston.vtc.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aston.vtc.model.Chauffeur;

public interface ChauffeurRepo extends JpaRepository<Chauffeur, Long>{
	/*
	 * Annotation importante pour supprimer l'entité
	 */
	@Transactional
	void deleteChauffeurById(int id);
	Optional<Chauffeur> findChauffeurById(int id);
}
