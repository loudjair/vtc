package fr.aston.vtc.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aston.vtc.model.Reservation;

public interface ReservationRepo extends JpaRepository<Reservation, Long>{

	@Transactional
	void deleteReservationById(int id);
	Optional<Reservation> findReservationById(int id);
}
