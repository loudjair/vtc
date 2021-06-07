package fr.aston.vtc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.aston.vtc.dto.TrajetDto;
import fr.aston.vtc.model.Trajet;
import fr.aston.vtc.service.TrajetService;

@RestController
@RequestMapping("/trajet")
public class TrajetResource {
	private final TrajetService trajetService;

	public TrajetResource(TrajetService trajetService) {
		super();
		this.trajetService = trajetService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<?>> getAllTrajets(){
		List<Trajet> trajets = trajetService.findAllTrajets();
		List<TrajetDto> trajetDtos = new ArrayList<TrajetDto>();
		for(Trajet trajet:trajets) {
			trajetDtos.add(new TrajetDto(trajet));
		}
		return new ResponseEntity<>(trajetDtos,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getTrajetById(@PathVariable("id") int id){
		Trajet trajet = trajetService.findTrajetById(id);
		return new ResponseEntity<>(new TrajetDto(trajet),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addTrajet(@RequestBody Trajet trajet){
		Trajet newTrajet = trajetService.addTrajet(trajet);
		TrajetDto trajetDto = new TrajetDto(newTrajet);
		
		return new ResponseEntity<>(trajetDto,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateTrajet(@RequestBody Trajet trajet){
		Trajet updateTrajet = trajetService.updateTrajet(trajet);
		return new ResponseEntity<>(new TrajetDto(updateTrajet),HttpStatus.OK);
	}
	
}
