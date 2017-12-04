package com.cdnuit.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cdnuit.iService.IUtilisateurService;
import com.cdnuit.model.Requete;
import com.cdnuit.repository.RequeteRepository;

@RestController
public class RequeteController {

	@Autowired
	RequeteRepository rq;
	
	@Autowired
	IUtilisateurService etudiantService;
	
	@Autowired
	IUtilisateurService profService;

	@RequestMapping(value = "/requetes", method = RequestMethod.GET)
	public ResponseEntity<List<Requete>> getAllRequetes() {
		return new ResponseEntity<>(rq.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/requetes", method = RequestMethod.POST)
	public ResponseEntity<?> createRequete(@RequestBody Requete req) {
		System.out.println(req.getDestinataire().getNom());
		etudiantService.EnvoyerRequete(req);
	    rq.save(req);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newReqUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(req.getId())
				.toUri();
		responseHeaders.setLocation(newReqUri);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}

}
