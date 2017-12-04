package com.cdnuit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.cdnuit.model.Admin;
import com.cdnuit.model.Professeur;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	

}
