package fr.aston.vtc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import fr.aston.vtc.dto.VehiculeDto;
import fr.aston.vtc.model.Vehicule;
import fr.aston.vtc.service.VehiculeService;

@RestController
@RequestMapping("/vehicule")
public class VehiculeResource {
	private final VehiculeService vehiculeService;
	
	public VehiculeResource(VehiculeService vehiculeService) {
		super();
		this.vehiculeService = vehiculeService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<?>> getAllVehicules(){
		List<Vehicule> vehicules = vehiculeService.findAllVehicules();
		List<VehiculeDto> vehiculeSDtos = new ArrayList<VehiculeDto>();
		for(Vehicule vehicule: vehicules) {
			vehiculeSDtos.add(new VehiculeDto(vehicule));
		}
		return new ResponseEntity<>(vehiculeSDtos,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findVehiculeById(@PathVariable("id") int id){
		 Vehicule vehicule = vehiculeService.findVehiculeById(id);
		return new ResponseEntity<>(new VehiculeDto(vehicule),HttpStatus.OK);
	}
		
	@PostMapping("/add")
	public ResponseEntity<?> addVehicule(@RequestBody Vehicule vehicule){
		Vehicule newVehicule = vehiculeService.addVehicule(vehicule);
		VehiculeDto vehiculeDto = new VehiculeDto(newVehicule);
		return new ResponseEntity<>(vehiculeDto,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateVehicule(@RequestBody Vehicule vehicule){
		 Vehicule updateVehicule = vehiculeService.updateVehicule(vehicule);
		return new ResponseEntity<>(new VehiculeDto(updateVehicule),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteVehicule(@PathVariable("id") int id){
		vehiculeService.deleteVehicule(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
