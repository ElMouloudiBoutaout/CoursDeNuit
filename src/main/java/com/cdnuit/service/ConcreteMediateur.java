package com.cdnuit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdnuit.iService.IUtilisateurService;
import com.cdnuit.iService.Mediateur;
import com.cdnuit.model.Requete;

@Service
public class ConcreteMediateur implements Mediateur {

	private IUtilisateurService profService;

	private IUtilisateurService etudiantService;

	@Autowired
	public void setProfService(IUtilisateurService profService) {
		this.profService = profService;
	}

	@Autowired
	public void setEtudiantService(IUtilisateurService etudiantService) {
		this.etudiantService = etudiantService;
	}

	@Override
	public void transmettreRequeteDeProfesseur(Requete requete) {
		// TODO Auto-generated method stub
		etudiantService.RecevoireRequete(requete);
	}

	@Override
	public void transmettreRequeteDeEtudiant(Requete requete) {
		// TODO Auto-generated method stub
		System.out.println(requete.getExpediteur().getNom());
		profService.RecevoireRequete(requete);
	}

}
