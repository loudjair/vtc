package fr.aston.vtc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aston.vtc.model.Reservation;

public interface ReservationRepo extends JpaRepository<Reservation, Long>{

}
