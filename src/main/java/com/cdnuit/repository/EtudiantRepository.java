package com.cdnuit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import com.cdnuit.model.Etudiant;


public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

}
