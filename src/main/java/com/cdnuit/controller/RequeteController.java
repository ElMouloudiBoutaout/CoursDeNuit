package com.cdnuit.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cdnuit.exception.ResourceNotFoundException;
import com.cdnuit.iService.IRequeteService;
import com.cdnuit.iService.IUtilisateurService;
import com.cdnuit.model.Professeur;
import com.cdnuit.model.Requete;
import com.cdnuit.repository.RequeteRepository;

@RestController
public class RequeteController {

	@Autowired
	private RequeteRepository rq;

	@Autowired
	private IUtilisateurService etudiantService;

	@Autowired
	private IRequeteService reqService;

	protected void verifierRequete(Long id) throws ResourceNotFoundException {
		Requete requete = rq.findOne(id);
		if (requete == null)
			throw new ResourceNotFoundException("Requete dont id " + id + " vaut introuvable");
	}

	@RequestMapping(value = "/requetes", method = RequestMethod.GET)
	public ResponseEntity<List<Requete>> getAllRequetes() {
		return new ResponseEntity<>(rq.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/requetes/{id}", method = RequestMethod.GET)
	public ResponseEntity<Requete> getRequete(@PathVariable Long id) {
		verifierRequete(id);
		return new ResponseEntity<>(rq.findOne(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/requetes", method = RequestMethod.POST)
	public ResponseEntity<?> createRequete(@RequestBody Requete req) {
		System.out.println(req.getId());
		rq.save(req);
		etudiantService.EnvoyerRequete(req);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newReqUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(req.getId())
				.toUri();
		responseHeaders.setLocation(newReqUri);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/professeurs/{profId}/offres/{reqId}/accepter", method = RequestMethod.PUT)
	public ResponseEntity<?> accepter(@RequestBody Requete req, @PathVariable Long reqId, @PathVariable Long profId) {
		verifierRequete(req.getId());
		if (req.getDestinataire().getId().equals(profId))
			reqService.accepterRequete(req);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/professeurs/{profId}/ofrres/{reqId}/refuser", method = RequestMethod.PUT)
	public ResponseEntity<?> refuser(@RequestBody Requete req, @PathVariable Long reqId, @PathVariable Long profId) {
		verifierRequete(req.getId());
		if (req.getDestinataire().getId().equals(profId))
			reqService.refuserRequete(req);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/etudiants/{etudId}/demandes/{reqId}/annuler", method = RequestMethod.PUT)
	public ResponseEntity<?> annuler(@RequestBody Requete req, @PathVariable Long reqId, @PathVariable Long etudId) {
		verifierRequete(req.getId());

		if (req.getExpediteur().getId().equals(etudId))
			reqService.supprimerRequete(req);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
