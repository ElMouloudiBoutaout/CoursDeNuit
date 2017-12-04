package com.cdnuit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cdnuit.iService.IUtilisateurService;
import com.cdnuit.iService.Mediateur;
import com.cdnuit.service.ConcreteMediateur;
import com.cdnuit.service.EtudiantService;
import com.cdnuit.service.ProfesseurService;

@Configuration
public class BeanConfig {
	
	@Bean
	Mediateur mediateur(){return new ConcreteMediateur();}
	
	@Bean
	IUtilisateurService etudiantService(){return  new EtudiantService();}
	
	@Bean
	IUtilisateurService profService(){return  new ProfesseurService();}

}
