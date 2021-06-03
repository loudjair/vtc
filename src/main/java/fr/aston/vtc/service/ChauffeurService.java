package fr.aston.vtc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aston.vtc.exception.ChauffeurNotFoundException;
import fr.aston.vtc.model.Chauffeur;
import fr.aston.vtc.repo.ChauffeurRepo;

@Service
public class ChauffeurService {

	private final ChauffeurRepo chauffeurRepo;
	//private final UserService userService;
	
	@Autowired
	public ChauffeurService(ChauffeurRepo chauffeurRepo) {
		super();
		this.chauffeurRepo = chauffeurRepo;
	}
	
	public Chauffeur addChauffeur(Chauffeur chauffeur) {
		return chauffeurRepo.save(chauffeur);
	}
	
	public List<Chauffeur> findAllChauffeurs(){
		return chauffeurRepo.findAll();
	}
	
	public Chauffeur updateChauffeur(Chauffeur chauffeur) {
		return chauffeurRepo.save(chauffeur);
	}
	
	public Chauffeur findChauffeurById(int id){
		return chauffeurRepo.findChauffeurById(id).orElseThrow(()-> new ChauffeurNotFoundException("Chauffeur by id "+id+" was not found"));
	}
	
	public void deleteChauffeur(int id) {
		chauffeurRepo.deleteChauffeurById(id);
	}
	

}
