package com.cdnuit.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.cdnuit.iService.Mediateur;

@Entity
public class Etudiant extends Utilisateur {

	
	@OneToMany(targetEntity = Requete.class)
	private List<Requete> demandes;

	public List<Requete> getDemandes() {
		return demandes;
	}

	public Etudiant() {
		super();
		this.demandes = new ArrayList<Requete>();
	}

	public void setDemandes(List<Requete> demandes) {
		this.demandes = demandes;
	}

}
