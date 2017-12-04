package com.cdnuit.iService;

import com.cdnuit.model.Requete;
import com.cdnuit.model.Utilisateur;

public interface Mediateur {
	
	
    public void transmettreRequeteDeProfesseur(Requete requete);
    public void transmettreRequeteDeEtudiant(Requete requete);

 
}
