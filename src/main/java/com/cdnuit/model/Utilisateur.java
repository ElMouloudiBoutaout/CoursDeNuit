package com.cdnuit.model;

import javax.persistence.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.cdnuit.enumartion.Genre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = Etudiant.class, name = "etudiant"),

		@JsonSubTypes.Type(value = Professeur.class, name = "professeur") })
public abstract class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ConfirmationCodeGenerator")
	@TableGenerator(table = "SEQUENCES", name = "ConfirmationCodeGenerator")
	private Long id;

	private String nom;
	private String prenom;
	private String email;
	private String motDepasse;

	@Enumerated(EnumType.STRING)
	private Genre genre;

	@Lob
	private Byte[] Image;

	public Utilisateur() {
		super();
	}

	public Utilisateur(String nom, String prenom, String email, String motDepasse, Genre genre) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDepasse = motDepasse;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte[] getImage() {
		return Image;
	}

	public void setImage(Byte[] image) {
		Image = image;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDepasse() {
		return motDepasse;
	}

	public void setMotDepasse(String motDepasse) {
		this.motDepasse = motDepasse;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

}
