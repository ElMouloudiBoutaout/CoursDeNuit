package com.cdnuit.iService;

import com.cdnuit.enumartion.EtatRequete;
import com.cdnuit.model.Requete;

public interface IRequeteService {
	
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
	
	
	public void supprimerRequete(Requete requete);

}
