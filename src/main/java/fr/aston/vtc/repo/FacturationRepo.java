package fr.aston.vtc.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aston.vtc.model.Facturation;

public interface FacturationRepo extends JpaRepository<Facturation, Long>{

	@Transactional
	void deleteFacturationById(int id);

	Optional<Facturation> findFacturationById(int id);

}
