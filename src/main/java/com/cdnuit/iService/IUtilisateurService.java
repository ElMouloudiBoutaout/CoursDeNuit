package com.cdnuit.iService;

import java.util.List;

import com.cdnuit.enumartion.EtatRequete;
import com.cdnuit.model.Etudiant;
import com.cdnuit.model.Requete;
import com.cdnuit.model.Utilisateur;

public interface IUtilisateurService {
	
	
	
	void EnvoyerRequete(Requete req);
	
	void RecevoireRequete(Requete requete);
	
	void update(Utilisateur utilisateur);
	
	 
	default public void accepterRequete(Requete requete) {
		// TODO Auto-generated method stub
		requete.setEtat(EtatRequete.Accepte);
	}

	 
	default public void refuserRequete(Requete requete) {
		// TODO Auto-generated method stub
		requete.setEtat(EtatRequete.Refuse);
	}

	 
	default public void annulerRequete(Requete requete) {
		// TODO Auto-generated method stub
		requete.setEtat(EtatRequete.Annule);
	}

	
}
