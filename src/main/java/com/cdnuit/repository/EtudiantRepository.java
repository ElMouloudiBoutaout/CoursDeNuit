package com.cdnuit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cdnuit.model.Etudiant;


public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	
	@Query("select etudiant from Etudiant etudiant where etudiant.nom = ?1")
	Etudiant findEtudiantbyNom(String nom);

}
