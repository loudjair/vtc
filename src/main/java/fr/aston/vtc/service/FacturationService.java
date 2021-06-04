package fr.aston.vtc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aston.vtc.exception.FacturationNotFoundException;
import fr.aston.vtc.model.Facturation;
import fr.aston.vtc.repo.FacturationRepo;


@Service
public class FacturationService {

	private final FacturationRepo facturationRepo;
	
	@Autowired
	public FacturationService(FacturationRepo facturationRepo) {
		super();
		this.facturationRepo = facturationRepo;
	}
	
	public Facturation addFacturation(Facturation facturation) {
		return facturationRepo.save(facturation);
	}
	
	public List<Facturation> findAllFacturations(){
		return facturationRepo.findAll();
	}
	
	public Facturation updateFacturation(Facturation facturation) {
		return facturationRepo.save(facturation);
	}
	
	public Facturation findFacturationById(int id){
		return facturationRepo.findFacturationById(id)
				.orElseThrow(()-> new FacturationNotFoundException("Facturation by id "+id+" was not found"));
	}
	
	public void deleteFacturation(int id) {
		facturationRepo.deleteFacturationById(id);
	}
	

}
