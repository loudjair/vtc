package fr.aston.vtc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.aston.vtc.dto.ReservationDto;
import fr.aston.vtc.model.Reservation;
import fr.aston.vtc.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationResource {
	private final ReservationService reservationService;

	public ReservationResource(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<?>> getAllReservations(){
		List<Reservation> reservations = reservationService.findAllReservations();
		List<ReservationDto> reservationsDtos = new ArrayList<ReservationDto>();
		for(Reservation reservation:reservations) {
			reservationsDtos.add(new ReservationDto(reservation));
		}
		return new ResponseEntity<>(reservationsDtos,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addReservation(@RequestBody Reservation reservation){
		Reservation newReservation = reservationService.addReservation(reservation);
		return new ResponseEntity<>(new ReservationDto(newReservation), HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getReservationById(@PathVariable("id") int id){
		return new ResponseEntity<>(new ReservationDto(reservationService.findReservationById(id)),HttpStatus.OK);
	}
	
	@GetMapping("/update")
	public ResponseEntity<?> getReservation(@RequestBody Reservation reservation){
		return new ResponseEntity<>(new ReservationDto(reservationService.updateReservation(reservation)),HttpStatus.OK);
	}
	
}
