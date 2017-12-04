package com.cdnuit.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;



@Entity
public class Professeur extends Utilisateur {
	
    @OneToMany( targetEntity=Requete.class )
	private List<Requete> offres;
	
	
	public Professeur(){
		offres = new ArrayList<Requete>();
	}

	public List<Requete> getOffres() {
		return offres;
	}

	public void setOffres(List<Requete> offres) {
		this.offres = offres;
	}


 
	
}
