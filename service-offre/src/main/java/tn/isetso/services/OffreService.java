package tn.isetso.services;

import org.springframework.http.HttpHeaders;

import tn.isetso.entities.Offre;

public interface OffreService {

	public Offre createOffre(OffreData offreData , HttpHeaders header);
}
