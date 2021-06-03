package fr.aston.vtc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aston.vtc.model.Facturation;

public interface FacturationRepo extends JpaRepository<Facturation, Long>{

}
