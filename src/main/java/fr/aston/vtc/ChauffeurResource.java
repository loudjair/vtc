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
import fr.aston.vtc.model.Vehicule;
import fr.aston.vtc.service.ChauffeurService;
import fr.aston.vtc.service.UserService;
import fr.aston.vtc.service.VehiculeService;

@RestController
@RequestMapping("/chauffeur")
public class ChauffeurResource {
	private final ChauffeurService chauffeurService;
	private final UserService userService;
	private final VehiculeService vehiculeService;
	
	public ChauffeurResource(ChauffeurService chauffeurService , UserService userService , VehiculeService vehiculeService) {
		super();
		this.chauffeurService = chauffeurService;
		this.userService = userService;
		this.vehiculeService = vehiculeService;
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
	
	/*
	 * Delete en trois temps, dans l'ordre suivant: 
	 * 1) Delete les vehicule(s)
	 * 2) Delete chauffeur
	 * 3) Delete user
	 * Pour éviter des erreurs liées aux clés étrangères
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteChauffeur(@PathVariable("id") int id){
		Chauffeur chauffeur = this.chauffeurService.findChauffeurById(id);
		List<Vehicule> vehicules = chauffeur.getVehicules();
		
		//Delete le(s) vehicule(s) du chauffeur
		for(Vehicule vehicule:vehicules) {
			this.vehiculeService.deleteVehicule(vehicule.getId());
		}
		
		//Delete chauffeur
		chauffeurService.deleteChauffeur(id);
		
		//Delete user
		userService.deleteUser(chauffeur.getUser().getId());
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}