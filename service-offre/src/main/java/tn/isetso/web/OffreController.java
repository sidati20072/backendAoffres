package tn.isetso.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.Request;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import tn.isetso.dao.CategoryRepository;
import tn.isetso.dao.OffreRepository;
import tn.isetso.entities.Category;
import tn.isetso.entities.Membre;
import tn.isetso.entities.Entreprise;
import tn.isetso.entities.Offre;
import tn.isetso.services.DemandeData;
import tn.isetso.services.OffreData;
import tn.isetso.services.OffreService;
@RestController

public class OffreController {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired 
	private OffreRepository offreRepository;
	@Autowired
	private OffreService offreService;
	
	@PostMapping("/create_offre")
	public Offre createOffre(@RequestBody OffreData data  , RestTemplate restTemplate ,  @RequestHeader HttpHeaders headers) {
						
			return this.offreService.createOffre(data, headers); 
		}
		
}
	
	
	

