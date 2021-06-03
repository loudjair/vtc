package fr.aston.vtc.repo;

import java.util.Optional;

import javax.transaction.Transactional;

//import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

//import fr.aston.vtc.model.Chauffeur;
import fr.aston.vtc.model.Vehicule;

public interface VehiculeRepo extends JpaRepository<Vehicule, Long>{
	/*
	 * Annotation importante pour supprimer le vehicule
	 */
	@Transactional
	void deleteVehiculeById(int id);
	Optional<Vehicule> findVehiculeById(int id);
	//Optional<Vehicule> findVehiculeByChauffeur(Chauffeur chauffeur,Sort sort);
}
