package tn.isetso.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.isetso.dao.OffreRepository;
import tn.isetso.entities.Category;
import tn.isetso.entities.Demande;
import tn.isetso.entities.Offre;
import tn.isetso.services.DemandeData;
import tn.isetso.services.DemandeService;

@RestController
public class DemandeController {
	
	@Autowired
	private OffreRepository offreRepository;
	@Autowired 
	private DemandeService demandeService;
	@PostMapping("/demandes")
	public Demande signUp(@RequestBody DemandeData data) {
		
		System.out.println(data);
		if (data.getOffreId()==null) throw new RuntimeException("offre required");
		Long offreId = Long.valueOf(data.getOffreId());
		if (offreRepository.findById(offreId)==null) throw new RuntimeException("offre introuvable");

		
		return demandeService.addDemande(offreId, data);
		}
		
}
