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

import fr.aston.vtc.dto.FacturationDto;
import fr.aston.vtc.model.Facturation;
import fr.aston.vtc.service.FacturationService;


@RestController
@RequestMapping("/facturation")
public class FacturationResource {
	private final FacturationService facturationService;
	
	public FacturationResource(FacturationService facturationService) {
		super();
		this.facturationService = facturationService;

	}
	
	@GetMapping("/all")
	public ResponseEntity<List<?>> getAllFacturations(){
		List<Facturation> facturations = facturationService.findAllFacturations();
		List<FacturationDto> facturationDtos = new ArrayList<FacturationDto>();
		for (Facturation facturation : facturations) {
			facturationDtos.add(new FacturationDto(facturation));
		}
		return new ResponseEntity<>(facturationDtos,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findFacturationById(@PathVariable("id") int id){
		 Facturation facturation = facturationService.findFacturationById(id);
		return new ResponseEntity<>(new FacturationDto(facturation),HttpStatus.OK);
	}
		
	@PostMapping("/add")
	public ResponseEntity<?> addFacturation(@RequestBody Facturation facturation){
		Facturation newFacturation = facturationService.addFacturation(facturation);
		FacturationDto facturationDto = new FacturationDto(newFacturation);

		return new ResponseEntity<>(facturationDto,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateFacturation(@RequestBody Facturation facturation){
		 Facturation updateFacturation = facturationService.updateFacturation(facturation);
		return new ResponseEntity<>(new FacturationDto(updateFacturation),HttpStatus.OK);
	}
	
	/*
	 * 1) Delete l'id
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteFacturation(@PathVariable("id") int id){
		this.facturationService.deleteFacturation(id);
			
		return new ResponseEntity<>(HttpStatus.OK);
	}
}