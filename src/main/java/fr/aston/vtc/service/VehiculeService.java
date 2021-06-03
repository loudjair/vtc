package fr.aston.vtc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aston.vtc.exception.VehiculeNotFoundException;
import fr.aston.vtc.model.Vehicule;
import fr.aston.vtc.repo.VehiculeRepo;

@Service
public class VehiculeService {
	private final VehiculeRepo vehiculeRepo;
	
	@Autowired
	public VehiculeService(VehiculeRepo vehiculeRepo) {
		super();
		this.vehiculeRepo = vehiculeRepo;
	}
	
	public Vehicule addVehicule(Vehicule vehicule) {
		return vehiculeRepo.save(vehicule);
	}
	
	public List<Vehicule> findAllVehicules(){
		return vehiculeRepo.findAll();
	}
	
	public Vehicule updateVehicule(Vehicule vehicule) {
		return vehiculeRepo.save(vehicule);
	}
	
	public Vehicule findVehiculeById(int id){
		return vehiculeRepo.findVehiculeById(id).orElseThrow(()-> new VehiculeNotFoundException("Vehicule by id "+id+" was not found"));
	}
	
	//  Trouver le(s) voiture(s) du vehicule
	/*
	
		public Vehicule findVehiculeByChauffeur(Chauffeur vehicule) {
			String vehiculeNom = vehicule.getUser().getNom();
			return vehiculeRepo.findVehiculeByChauffeur(vehicule, null)
				.orElseThrow(()->new VehiculeNotFoundException("Vehicule by id "+ vehiculeNom +" was not found"));
		}
	*/
	
	public void deleteVehicule(int id) {
		vehiculeRepo.deleteVehiculeById(id);
	}
}
