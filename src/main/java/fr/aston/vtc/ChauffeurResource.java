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

import fr.aston.vtc.dto.ChauffeurDto;
import fr.aston.vtc.model.Chauffeur;
import fr.aston.vtc.service.ChauffeurService;

@RestController
@RequestMapping("/chauffeur")
public class ChauffeurResource {
	private final ChauffeurService chauffeurService;
	
	public ChauffeurResource(ChauffeurService chauffeurService) {
		super();
		this.chauffeurService = chauffeurService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<?>> getAllChauffeurs(){
		//List<Chauffeur> chauffeurs = chauffeurService.findAllChauffeurs();
		List<Chauffeur> chauffeurs = chauffeurService.findAllChauffeurs();
		List<ChauffeurDto> chDtos = new ArrayList<ChauffeurDto>();
		for (Chauffeur chauffeur : chauffeurs) {
			chDtos.add(new ChauffeurDto(chauffeur));
		}
		return new ResponseEntity<>(chDtos,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findChauffeurById(@PathVariable("id") int id){
		 Chauffeur chauffeur = chauffeurService.findChauffeurById(id);
		return new ResponseEntity<>(new ChauffeurDto(chauffeur),HttpStatus.OK);
	}
		
	@PostMapping("/add")
	public ResponseEntity<?> addChauffeur(@RequestBody Chauffeur chauffeur){
		Chauffeur newChauffeur = chauffeurService.addChauffeur(chauffeur);
		ChauffeurDto chauffeurDto = new ChauffeurDto(newChauffeur);

		
		return new ResponseEntity<>(chauffeurDto,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateChauffeur(@RequestBody Chauffeur chauffeur){
		 Chauffeur updateChauffeur = chauffeurService.updateChauffeur(chauffeur);
		return new ResponseEntity<>(new ChauffeurDto(updateChauffeur),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteChauffeur(@PathVariable("id") int id){
		chauffeurService.deleteChauffeur(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
