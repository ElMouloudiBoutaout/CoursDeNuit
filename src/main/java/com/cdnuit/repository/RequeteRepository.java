package com.cdnuit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cdnuit.model.Requete;

public interface RequeteRepository extends JpaRepository<Requete, Long> {

}
