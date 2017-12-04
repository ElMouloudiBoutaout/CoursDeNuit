package com.cdnuit.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdnuit.iService.IUtilisateurService;
import com.cdnuit.iService.Mediateur;
import com.cdnuit.model.Professeur;
import com.cdnuit.model.Requete;
import com.cdnuit.model.Utilisateur;
import com.cdnuit.repository.ProfesseurRepository;

public class ProfesseurService implements IUtilisateurService {
	@Autowired
	protected Mediateur mediateur;
	@Autowired
	private ProfesseurRepository profRepo;

	@Override
	public void EnvoyerRequete(Requete req) {
		// TODO Auto-generated method stub
		mediateur.transmettreRequeteDeEtudiant(req);
	}

	@Override
	public void RecevoireRequete(Requete requete) {
		// TODO Auto-generated method stub
		System.out.println("from "+requete.getExpediteur().getNom()+" to "+requete.getDestinataire().getNom());
	}

	@Override
	public void update(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		Professeur prof= profRepo.findOne(utilisateur.getId());
	}
	
}
