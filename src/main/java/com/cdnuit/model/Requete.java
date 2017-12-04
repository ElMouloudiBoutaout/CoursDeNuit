package com.cdnuit.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import com.cdnuit.enumartion.EtatRequete;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
public class Requete {

	@OneToOne
	@JsonDeserialize(as=Etudiant.class)
	private Utilisateur createur;
	
	@OneToOne
	@JsonDeserialize(as=Professeur.class)
	private Utilisateur destination;

	public Requete(Utilisateur createur, Utilisateur destinataire) {
		super();
		this.createur = createur;
		this.destination = destinataire;
	}

	public Requete() {
		// TODO Auto-generated constructor stub
	}

	public Utilisateur getExpediteur() {
		return createur;
	}

	public void setExpediteur(Utilisateur expediteur) {
		createur = expediteur;
	}

	public Utilisateur getDestinataire() {
		return destination;
	}

	public void setDestinataire(Utilisateur destinataire) {
		this.destination = destinataire;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private EtatRequete etat = EtatRequete.En_Cours;;

	public Long getId() {
		return id;
	}

	public EtatRequete getEtat() {
		return etat;
	}

	public void setEtat(EtatRequete etat) {
		this.etat = etat;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
