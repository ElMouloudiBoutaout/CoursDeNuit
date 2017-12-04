package com.cdnuit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdnuit.model.Professeur;
public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {

}
