package com.cdnuit.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdnuit.iService.IProfesseurService;
import com.cdnuit.iService.IUtilisateurService;
import com.cdnuit.iService.Mediateur;
import com.cdnuit.model.Professeur;
import com.cdnuit.model.Requete;
import com.cdnuit.model.Utilisateur;
import com.cdnuit.repository.ProfesseurRepository;
import com.cdnuit.repository.RequeteRepository;

public class ProfesseurService implements IUtilisateurService,IProfesseurService {
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
	public void RecevoireRequete(Requete req) {
		// TODO Auto-generated method stub
		System.out.println("from "+req.getExpediteur().getNom()+" to "+req.getDestinataire().getNom());
		Professeur p = profRepo.findOne(req.getDestinataire().getId());
		System.out.println(p.getOffres());
		p.getOffres().add(req);
		this.update(p);
	}
	
	
	@Override
	public void update(Professeur professeur) {
		// TODO Auto-generated method stub
		profRepo.save(professeur);
	}

	
}
