package fr.aston.vtc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.aston.vtc.exception.TrajetNotFoundException;
import fr.aston.vtc.model.Trajet;
import fr.aston.vtc.repo.TrajetRepo;

public class TrajetService {

	private final TrajetRepo trajetRepo;

	@Autowired
	public TrajetService(TrajetRepo trajetRepo) {
		super();
		this.trajetRepo = trajetRepo;
	}
	public Trajet addTrajet(Trajet trajet) {
		return trajetRepo.save(trajet);
	}
	
	public List<Trajet> findAllTrajets(){
		return trajetRepo.findAll();
	}
	
	public Trajet updateTrajet(Trajet trajet) {
		return trajetRepo.save(trajet);
	}
	
	public Trajet findTrajetById(int id){
		return trajetRepo.findTrajetById(id).orElseThrow(()-> new TrajetNotFoundException("Trajet by id "+id+" was not found"));
	}
	
	public void deleteTrajet(int id) {
		trajetRepo.deleteTrajetById(id);
	}
}
