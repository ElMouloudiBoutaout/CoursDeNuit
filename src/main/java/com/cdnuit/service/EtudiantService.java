package com.cdnuit.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdnuit.iService.IUtilisateurService;
import com.cdnuit.iService.Mediateur;
import com.cdnuit.model.Etudiant;
import com.cdnuit.model.Requete;
import com.cdnuit.model.Utilisateur;
import com.cdnuit.repository.EtudiantRepository;

public class EtudiantService implements IUtilisateurService {
	@Autowired
	protected Mediateur mediateur;
	@Autowired
	private EtudiantRepository etudiantRepo;

	@Override
	public void EnvoyerRequete(Requete req) {
		// TODO Auto-generated method stub
		mediateur.transmettreRequeteDeEtudiant(req);
	}

	@Override
	public void RecevoireRequete(Requete requete) {
		// TODO Auto-generated method stub
		System.out.println("from " + requete.getExpediteur().getNom() + " to " + requete.getDestinataire());

	}

	@Override
	public void update(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		Etudiant etudiant = etudiantRepo.findOne(utilisateur.getId());
	}

}
