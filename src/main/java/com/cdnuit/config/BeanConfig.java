package com.cdnuit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cdnuit.iService.IRequeteService;
import com.cdnuit.iService.IUtilisateurService;
import com.cdnuit.iService.Mediateur;
import com.cdnuit.security.UtilisateurDetailService;
import com.cdnuit.service.ConcreteMediateur;
import com.cdnuit.service.EtudiantService;
import com.cdnuit.service.ProfesseurService;
import com.cdnuit.service.RequeteService;

@Configuration
public class BeanConfig {
	
	@Bean
	Mediateur mediateur(){return new ConcreteMediateur();}
	
	@Bean
	IUtilisateurService etudiantService(){return  new EtudiantService();}
	
	@Bean
	IUtilisateurService profService(){return  new ProfesseurService();}
	
	@Bean
	IRequeteService reqService(){return  new RequeteService();}
	
	@Bean
	UtilisateurDetailService uDs(){
		return new UtilisateurDetailService();
	}
}
