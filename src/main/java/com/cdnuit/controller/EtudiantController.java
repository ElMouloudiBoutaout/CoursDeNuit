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

import com.cdnuit.model.Etudiant;
import com.cdnuit.repository.EtudiantRepository;

@RestController
public class EtudiantController {
	
	@Autowired 
	private EtudiantRepository etudiantRepo;

	
	@GetMapping("/etudiants")
	public List<Etudiant> getAllEtudiants() {
	    return etudiantRepo.findAll();
	}
	
	@PostMapping("/etudiants")
	public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
	    return etudiantRepo.save(etudiant);
	}

	@GetMapping("/etudiants/{id}")
	public ResponseEntity<Etudiant> getEtudiantById(@PathVariable(value = "id") Long id) {
	    Etudiant etudiant = etudiantRepo.findOne(id);
	    if(etudiant == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(etudiant);
	}
	
	@PutMapping("/etudiants/{id}")
	public ResponseEntity<Etudiant> updateEtudiant(@PathVariable(value = "id") Long id, 
	                                        @RequestBody Etudiant etudiantupdated) {
	    Etudiant etudiant = etudiantRepo.findOne(id);
	    if(etudiant == null) {
	        return ResponseEntity.notFound().build();
	    }
	    etudiant.setDemandes(etudiantupdated.getDemandes());
	    etudiant.setEmail(etudiantupdated.getEmail());
	    etudiant.setGenre(etudiantupdated.getGenre());
	    etudiant.setImage(etudiantupdated.getImage());
	    etudiant.setNom(etudiantupdated.getNom());
	    etudiant.setPrenom(etudiantupdated.getPrenom());


	    
	    Etudiant updatedetudiant = etudiantRepo.save(etudiant);
	    return ResponseEntity.ok(updatedetudiant);
	}
	
	@DeleteMapping("/etudiants/{id}")
	public ResponseEntity<Etudiant> deleteEtudiant(@PathVariable(value = "id") Long id) {
	    Etudiant etudiant = etudiantRepo.findOne(id);
	    if(etudiant == null) {
	        return ResponseEntity.notFound().build();
	    }

	    etudiantRepo.delete(etudiant);
	    return ResponseEntity.ok().build();
	}
	
}
