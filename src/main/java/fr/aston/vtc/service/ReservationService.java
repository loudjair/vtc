package fr.aston.vtc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aston.vtc.exception.ReservationNotFoundException;
import fr.aston.vtc.model.Reservation;
import fr.aston.vtc.repo.ReservationRepo;

@Service
public class ReservationService {
	private final ReservationRepo reservationRepo;
	
	@Autowired
	public ReservationService(ReservationRepo reservationRepo) {
		super();
		this.reservationRepo = reservationRepo;
	}
	
	public Reservation addReservation(Reservation reservation) {
		return reservationRepo.save(reservation);
	}
	
	public List<Reservation> findAllReservations() {
		return reservationRepo.findAll();
	}
	
	public Reservation updateReservation(Reservation reservation) {
		return reservationRepo.save(reservation);
	}
	
	public Reservation findReservationById(int id) {
		return reservationRepo.findReservationById(id).orElseThrow(() -> new ReservationNotFoundException("Reservation by id "+id+" was not found"));
	}
	
	public void deleteReservation(int id) {
		reservationRepo.deleteReservationById(id);
	}
}
