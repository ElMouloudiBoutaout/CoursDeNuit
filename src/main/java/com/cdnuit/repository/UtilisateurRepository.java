package com.cdnuit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cdnuit.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
	
	@Query("select u from Utilisateur u where u.email = ?1")
	Utilisateur touverUParemail(String email);
	
}
