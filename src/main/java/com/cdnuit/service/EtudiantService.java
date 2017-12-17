package com.cdnuit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdnuit.iService.IEtudiantService;
import com.cdnuit.iService.IUtilisateurService;
import com.cdnuit.iService.Mediateur;
import com.cdnuit.model.Etudiant;
import com.cdnuit.model.Professeur;
import com.cdnuit.model.Requete;
import com.cdnuit.model.Utilisateur;
import com.cdnuit.repository.EtudiantRepository;
import com.cdnuit.repository.RequeteRepository;

@Service
public class EtudiantService implements IUtilisateurService, IEtudiantService {
	@Autowired
	protected Mediateur mediateur;
	@Autowired
	private EtudiantRepository etudiantRepo;

	@Autowired
	private RequeteRepository requeteRepo;

	@Override
	public void EnvoyerRequete(Requete req) {
		// TODO Auto-generated method stub
		mediateur.transmettreRequeteDeEtudiant(req);
		Etudiant etudiant = etudiantRepo.findOne(req.getExpediteur().getId());
		etudiant.getDemandes().add(req);
		this.update(etudiant);
	}

	@Override
	public void RecevoireRequete(Requete requete) {
		// TODO Auto-generated method stub
		System.out.println("from " + requete.getExpediteur().getNom() + " to " + requete.getDestinataire());
	}

	@Override
	public void update(Etudiant etudiant) {
		// TODO Auto-generated method stub
		if (etudiantRepo.getOne(etudiant.getId()) != null)
			etudiantRepo.save(etudiant);
	}


 

}
