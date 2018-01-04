package com.cdnuit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdnuit.model.Professeur;
import com.cdnuit.repository.ProfesseurRepository;

@RestController
public class ProfesseurController {
	
	
	@Autowired 
	private ProfesseurRepository professeurRepo;

	
	@GetMapping("/professeurs")
	public List<Professeur> getAllProfesseurs() {
	    return professeurRepo.findAll();
	}
	
	@PostMapping("/professeurs")
	public Professeur createProfesseur(@RequestBody Professeur professeur) {
	    return professeurRepo.save(professeur);
	}

	@GetMapping("/professeurs/{id}")
	public ResponseEntity<Professeur> getProfesseurById(@PathVariable(value = "id") Long id) {
	    Professeur professeur = professeurRepo.findOne(id);
	    if(professeur == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(professeur);
	}
	
	@PutMapping("/professeurs/{id}")
	public ResponseEntity<Professeur> updateProfesseur(@PathVariable(value = "id") Long id, 
	                                        @RequestBody Professeur professeurupdated) {
	    Professeur professeur = professeurRepo.findOne(id);
	    if(professeur == null) {
	        return ResponseEntity.notFound().build();
	    }
	    professeur.setOffres(professeurupdated.getOffres());
	    professeur.setEmail(professeurupdated.getEmail());
	    professeur.setGenre(professeurupdated.getGenre());
	    professeur.setImage(professeurupdated.getImage());
	    professeur.setNom(professeurupdated.getNom());
	    professeur.setPrenom(professeurupdated.getPrenom());


	    
	    Professeur updatedprofesseur = professeurRepo.save(professeur);
	    return ResponseEntity.ok(updatedprofesseur);
	}
	
	@DeleteMapping("/professeurs/{id}")
	public ResponseEntity<Professeur> deleteProfesseur(@PathVariable(value = "id") Long id) {
	    Professeur professeur = professeurRepo.findOne(id);
	    if(professeur == null) {
	        return ResponseEntity.notFound().build();
	    }

	    professeurRepo.delete(professeur);
	    return ResponseEntity.ok().build();
	}
	
}
