package tn.isetso.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import tn.isetso.dao.DemandeRepository;
import tn.isetso.dao.OffreRepository;
import tn.isetso.entities.Demande;
import tn.isetso.entities.Membre;
import tn.isetso.entities.Offre;

@Service
@Transactional	
public class DemandeServiceImpl implements DemandeService {

	@Autowired
	private OffreRepository offreRepository;
	
	@Autowired
	private DemandeRepository demandeRepository;
	
	@Override
	public Demande addDemande(Long idOffre, DemandeData data) {
		
		Offre offre= offreRepository.getOne(idOffre);
		System.out.println(offre);
		Date dateExecution=null;
		try {
			dateExecution = new SimpleDateFormat("dd/MM/yyyy").parse(data.getDateExecution());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate =new RestTemplate();
		Membre membre = restTemplate.getForObject("http://localhost:8180/membres/{id}", Membre.class, data.getUserId());

		Demande demande = new Demande(null, new Date(), dateExecution, data.getDuree(), data.getDescription(), data.getTarif(), "pending", data.getDevis(), membre, offre);		
		
		System.out.println(demande);
		try {
			demandeRepository.save(demande);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return demande;
	}

	
}
