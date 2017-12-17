package com.cdnuit.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdnuit.iService.IRequeteService;
import com.cdnuit.model.Etudiant;
import com.cdnuit.model.Professeur;
import com.cdnuit.model.Requete;
import com.cdnuit.repository.EtudiantRepository;
import com.cdnuit.repository.ProfesseurRepository;
import com.cdnuit.repository.RequeteRepository;

public class RequeteService implements IRequeteService {

	@Autowired
	private RequeteRepository rq;

	@Autowired
	private EtudiantRepository etudiantRepo;

	@Autowired
	private ProfesseurRepository profRepo;
	
	@Autowired
	private EtudiantService etudiantService;
	
	@Autowired
	private ProfesseurService profService;
	
	@Override
	public void accepterRequete(Requete requete) {
		// TODO Auto-generated method stub
		IRequeteService.super.accepterRequete(requete);
		update(requete);
	}

	@Override
	public void refuserRequete(Requete requete) {
		// TODO Auto-generated method stub
		IRequeteService.super.refuserRequete(requete);
		update(requete);

	}

	@Override
	public void annulerRequete(Requete requete) {
		// TODO Auto-generated method stub
		supprimerRequete(requete);
	}

	public void update(Requete requete) {
		if (rq.getOne(requete.getId()) != null)
			rq.save(requete);
	}

	@Override
	public void supprimerRequete(Requete requete) {
		// TODO Auto-generated method stub
		Professeur prof = profRepo.getOne(requete.getDestinataire().getId());
		Etudiant etudiant = etudiantRepo.getOne(requete.getExpediteur().getId());
		etudiant.getDemandes().remove(requete);
		prof.getOffres().remove(requete);
		etudiantService.update(etudiant);
		profService.update(prof);
		rq.delete(requete.getId());
	}

}
